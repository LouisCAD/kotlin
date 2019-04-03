/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.resolve.calls.inference.components

import org.jetbrains.kotlin.builtins.KotlinBuiltIns
import org.jetbrains.kotlin.descriptors.TypeParameterDescriptor
import org.jetbrains.kotlin.resolve.calls.components.ClassicTypeSystemContextForCS
import org.jetbrains.kotlin.resolve.calls.inference.ConstraintSystemBuilder
import org.jetbrains.kotlin.resolve.calls.inference.model.NewConstraintSystemImpl
import org.jetbrains.kotlin.resolve.calls.inference.model.SimpleConstraintSystemConstraintPosition
import org.jetbrains.kotlin.resolve.calls.inference.model.TypeVariableFromCallableDescriptor
import org.jetbrains.kotlin.resolve.calls.inference.substitute
import org.jetbrains.kotlin.resolve.calls.results.SimpleConstraintSystem
import org.jetbrains.kotlin.types.TypeConstructorSubstitution
import org.jetbrains.kotlin.types.TypeSubstitutor
import org.jetbrains.kotlin.types.UnwrappedType
import org.jetbrains.kotlin.types.model.KotlinTypeMarker
import org.jetbrains.kotlin.types.model.TypeParameterMarker
import org.jetbrains.kotlin.types.model.TypeSystemInferenceExtensionContext
import org.jetbrains.kotlin.types.typeUtil.asTypeProjection

class SimpleConstraintSystemImpl(constraintInjector: ConstraintInjector, builtIns: KotlinBuiltIns) : SimpleConstraintSystem {
    val system = NewConstraintSystemImpl(constraintInjector, ClassicTypeSystemContextForCS(builtIns))
    val csBuilder: ConstraintSystemBuilder =
        system.getBuilder()

    override fun registerTypeVariables(typeParameters: Collection<TypeParameterMarker>): TypeSubstitutor {

        val substitutionMap = typeParameters.associate {
            require(it is TypeParameterDescriptor)
            val variable = TypeVariableFromCallableDescriptor(it)
            csBuilder.registerVariable(variable)

            it.defaultType.constructor to variable.defaultType.asTypeProjection()
        }
        val substitutor = TypeConstructorSubstitution.createByConstructorsMap(substitutionMap).buildSubstitutor()
        for (typeParameter in typeParameters) {
            require(typeParameter is TypeParameterDescriptor)
            for (upperBound in typeParameter.upperBounds) {
                addSubtypeConstraint(substitutor.substitute(typeParameter.defaultType), substitutor.substitute(upperBound.unwrap()))
            }
        }
        return substitutor
    }

    override fun addSubtypeConstraint(subType: KotlinTypeMarker, superType: KotlinTypeMarker) {
        require(subType is UnwrappedType)
        require(superType is UnwrappedType)
        csBuilder.addSubtypeConstraint(subType, superType, SimpleConstraintSystemConstraintPosition)
    }

    override fun hasContradiction() = csBuilder.hasContradiction
    override val captureFromArgument get() = true

    override val context: TypeSystemInferenceExtensionContext
        get() = system
}