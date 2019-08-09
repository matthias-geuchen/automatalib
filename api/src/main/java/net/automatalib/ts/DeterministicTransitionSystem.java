/* Copyright (C) 2013-2019 TU Dortmund
 * This file is part of AutomataLib, http://www.automatalib.net/.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.automatalib.ts;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import net.automatalib.ts.simple.SimpleDTS;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Deterministic transition system. Like a {@link TransitionSystem}, but in each state there may exist at most one
 * transition for each input symbol.
 *
 * @param <S>
 *         state class
 * @param <I>
 *         input symbol class
 * @param <T>
 *         transition class
 *
 * @author Malte Isberner
 */
public interface DeterministicTransitionSystem<S, I, T> extends TransitionSystem<S, I, T>, SimpleDTS<S, I> {

    @Override
    @Nullable
    default S getSuccessor(S state, I input) {
        T trans = getTransition(state, input);
        if (trans == null) {
            return null;
        }
        return getSuccessor(trans);
    }

    /**
     * Retrieves the transition triggered by the given input symbol.
     *
     * @param state
     *         the source state.
     * @param input
     *         the input symbol.
     *
     * @return the transition triggered by the given input symbol, or <code>null</code> if no transition is triggered.
     *
     * @see TransitionSystem#getTransitions(Object, Object)
     */
    @Nullable
    T getTransition(S state, I input);

    @Override
    @NonNull
    default Set<S> getSuccessors(S state, I input) {
        return SimpleDTS.super.getSuccessors(state, input);
    }

    @Override
    @NonNull
    default Collection<T> getTransitions(S state, I input) {
        return transToSet(getTransition(state, input));
    }

    @NonNull
    static <T> Set<T> transToSet(T trans) {
        if (trans == null) {
            return Collections.emptySet();
        }
        return Collections.singleton(trans);
    }

}
