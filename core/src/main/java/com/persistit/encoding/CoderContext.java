/**
 * Copyright (C) 2011 Akiban Technologies Inc.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses.
 */

package com.persistit.encoding;

import java.io.Serializable;

import com.persistit.Key;
import com.persistit.Value;

/**
 * A marker interface for an application-specific object that may be passed to a
 * {@link KeyCoder} or {@link ValueCoder}. This object may be used to pass
 * application context information from the application to the coder instance.
 * The following methods accept a <tt>CoderContext</tt>:
 * <ul>
 * <li>{@link Key#append(Object, CoderContext)}</li>
 * <li>{@link Key#decode(Object, CoderContext)}</li>
 * <li>{@link Key#decodeString(CoderContext)}</li>
 * <li>{@link Key#decodeString(StringBuilder, CoderContext)}</li>
 * <li>{@link Key#decodeDisplayable(boolean, StringBuilder, CoderContext)}</li>
 * <li>{@link Value#put(Object, CoderContext)}</li>
 * <li>{@link Value#get(Object, CoderContext)}</li>
 * </ul>
 * This interface has no behavior; it simply marks classes that are intended for
 * this purpose to enhance type safety. Note that <tt>CoderContext</tt> extends
 * <tt>java.io.Serializable</tt>, meaning that any object you provide as a
 * CoderContext must behave correctly when serialized and deserialized.
 * 
 * @version 1.0
 */
public interface CoderContext extends Serializable {

}
