/* Copyright (C) 2013-2014 TU Dortmund
 * This file is part of AutomataLib, http://www.automatalib.net/.
 * 
 * AutomataLib is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 3.0 as published by the Free Software Foundation.
 * 
 * AutomataLib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with AutomataLib; if not, see
 * http://www.gnu.de/documents/lgpl.en.html.
 */
package net.automatalib.graphs.concepts;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * Edge weights concepts. Allows to associate a fractional (floating-point) <i>weight</i>
 * with the edges in a graph.
 * 
 * @author Malte Isberner 
 *
 * @param <E> edge class
 */
@ParametersAreNonnullByDefault
public interface EdgeWeights<E> {
	
	/**
	 * Retrieves the weight of an edge.
	 * @param edge the edge
	 * @return the weight of the given edge
	 */
	float getEdgeWeight(E edge);
}
