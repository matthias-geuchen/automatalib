/* Copyright (C) 2013-2021 TU Dortmund
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
package net.automatalib.modelcheckers.m3c.solver;

import net.automatalib.graphs.ContextFreeModalProcessSystem;
import net.automatalib.modelcheckers.m3c.formula.parser.M3CParser;
import net.automatalib.modelcheckers.m3c.formula.parser.ParseException;

/**
 * A {@link BDDSolver BDD solver} for generic, string-based formulas.
 *
 * @author frohme
 */
public class StringBDDSolver extends BDDSolver<String, String> implements M3CSolver<String> {

    StringBDDSolver(ContextFreeModalProcessSystem<String, String> cfmps) {
        super(cfmps);
    }

    @Override
    public boolean solve(String formula) throws ParseException {
        return super.solve(M3CParser.parse(formula));
    }

}
