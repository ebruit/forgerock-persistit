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

package com.persistit.unit;

import java.io.Serializable;

import com.persistit.Exchange;
import com.persistit.encoding.CoderManager;
import com.persistit.exception.PersistitException;

public class ValueTest5 extends PersistitUnitTestCase {
    /**
     * Tests JSA 1.1 default serialization. Requires the
     * enableCompatibleConstructors to be true.
     */

    Exchange _exchange;

    public enum Job {
        COOK, BOTTLEWASHER, PROGRAMMER, JANITOR, SALEMAN,
    };

    public static class S implements Serializable {
        private final static long serialVersionUID = 1;
        Job _myJob;
        Job _yourJob;

        S(Job m, Job y) {
            _myJob = m;
            _yourJob = y;
        }

        public String toString() {
            return _myJob + ":" + _yourJob;
        }

    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        _exchange = _persistit.getExchange("persistit", getClass()
                .getSimpleName(), true);
    }

    @Override
    public void tearDown() throws Exception {
        _persistit.releaseExchange(_exchange);
        super.tearDown();
    }

    public void test1() throws PersistitException {
        System.out.print("test1 ");
        S s = new S(Job.COOK, Job.BOTTLEWASHER);
        _exchange.getValue().put(s);
        _exchange.clear().append("test1").store();
        Object x = _exchange.getValue().get();
        assertEquals("COOK:BOTTLEWASHER", x.toString());

        System.out.println("- done");
    }

    public static void main(String[] args) throws Exception {
        new ValueTest5().initAndRunTest();
    }

    public void runAllTests() throws Exception {
        _exchange = _persistit.getExchange("persistit", "ValueTest5", true);
        CoderManager cm = _persistit.getCoderManager();

        test1();

        _persistit.setCoderManager(cm);
    }

}
