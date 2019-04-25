/*
 * Copyright 2010-2019 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.deserialization

import org.jetbrains.kotlin.fir.FirSession
import org.jetbrains.kotlin.fir.expressions.FirAnnotationCall
import org.jetbrains.kotlin.metadata.ProtoBuf
import org.jetbrains.kotlin.metadata.deserialization.Flags
import org.jetbrains.kotlin.metadata.deserialization.NameResolver

class FirBuiltinAnnotationDeserializer(
    session: FirSession, nameResolver: NameResolver
) : AbstractAnnotationDeserializer(session, nameResolver) {

    override fun loadTypeAnnotations(typeProto: ProtoBuf.Type): List<FirAnnotationCall> {
        if (!Flags.HAS_ANNOTATIONS.get(typeProto.flags)) return emptyList()
        val annotations = typeProto.getExtension(protocol.typeAnnotation).orEmpty()
        return annotations.map { deserializeAnnotation(it) }
    }
}