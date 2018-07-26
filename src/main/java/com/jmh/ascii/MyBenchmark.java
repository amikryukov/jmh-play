/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package com.jmh.ascii;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class MyBenchmark {

    /**
     * Sample of phrases from RTP Production
     */
    private static final String[] PHRASES = {
            "dinnerware sets",
            "double stroller",
            "dresser",
            "dressy dresses",
            "dw cuff",
            "easy spirit",
            "eclat",
            "eileen fisher jumpsuit",
            "eileen fisher sale",
            "electric crock pot",
            "elie tahari womens clothing",
            "embroidered towels",
            "empire waist",
            "empire waist top",
            "en créme",
            "equipment",
            "erase paste concealer",
            "erase paste concealer benefit",
            "evening",
            "evening dresses",
            "evil eye jewelry",
            "exquisite j",
            "eyelash curlers",
            "fanny packs",
            "faux fur scarves",
            "finish line women",
            "first impressions",
            "fit and flare dresses",
            "floral dresses",
            "foxiedox womens",
            "fram",
            "fram jeans",
            "free people tops",
            "french connection",
            "full xl sheets",
            "fur trimmed coats",
            "girl backpack",
            "girls backpacks",
            "girls clothes",
            "girls sweaters",
            "gold flatware",
            "gold stud earrings",
            "golf clothes",
            "goyard iphone case case",
            "green bar stools",
            "grey bed",
            "grey crewneck sweater",
            "gucci bloom",
            "gucci crossbody bag",
            "gucci iphone case",
            "gucci loafers for women",
            "gucci platform sandals",
            "gucci sale",
            "gucci sandals",
            "gucci shoes",
            "gucci slides",
            "guess women",
            "guess women clothing",
            "handbags",
            "handbags new arrivals",
            "herno",
            "hyaluronic acid",
            "inc international concepts jewelry",
            "inc international concepts ladies pants",
            "inc international concepts pendant",
            "inc ladies sweaters",
            "inc shirst men",
            "iron",
            "ivanka trump",
            "izod skort",
            "j brand jeans",
            "j goodman",
            "jaipur",
            "jason markk",
            "jbl",
            "jbu sunny",
            "jean skirt",
            "jeans",
            "jessica howard plus size dresses",
            "jewelry",
            "jo malone london",
            "joie",
            "jump suit",
            "jumpsuit",
            "jumpsuits and rompers for women",
            "junior new arrivals",
            "juniors formal dresses",
            "karen kane",
            "karen scott capri pants",
            "karen scott dresses",
            "karl lagerfeld",
            "kasper suits",
            "kassatex",
            "kat burki",
            "kate",
            "kate spade",
            "kate spade new york",
            "kate spade new york bags",
            "kate spade new york handbags",
            "keds",
            "keds womens shoes",
            "kendra scott sale",
            "kenneth cole white perfume",
            "kids backpacks unicorn",
            "kids rompers",
            "kids school uniforms",
            "kids shoes",
            "kim cami",
            "kimiko",
            "kinetix",
            "kipling",
            "kitchen",
            "kitchen pot holders",
            "knit ties",
            "kork",
            "kork ease",
            "kors purse",
            "la brune et la blonde",
            "la maison talulah",
            "lace dresses for women",
            "lacoste men",
            "ladies crewneck sweaters",
            "lancôme",
            "lancôme powder",
            "large canvas wall art",
            "last act plus size",
            "last act shoes",
            "last act shoes women",
            "lauren petites",
            "lauren ralph lauren dresses",
            "layered look",
            "le creuset",
            "leather",
            "leather recliner chair",
            "leather skirt",
            "lenox enamel canister",
            "leopard print skirt",
            "leota",
            "levis tee",
            "limoges",
            "little girl shoes",
            "little me baby girl",
            "living room accesoir",
            "living room furniture",
            "long cardigan",
            "long white dress",
            "lucy paris",
            "luggage",
            "luggage sale",
            "mac cosmetics near me",
            "mac makeup",
            "macy jeans",
            "mar y sol",
            "marc new york",
            "mark fisher",
            "marni",
            "maximilian furs",
            "maxmara",
            "mcm bag",
            "mcm boston",
            "meats",
            "memory foam topper",
            "men clarks shoes",
            "men flat white kenett cole shoes",
            "men peacoat",
            "men skin care",
            "men skin care kit",
            "men's white hat",
            "mens blazers and sport coats",
            "mens cologne",
            "mens face wash",
            "mens grey dress shoes",
            "mens gucci backpacks",
            "mens gucci shirt",
            "mens jockey underwear",
            "mens linen pants",
            "mens linen suit",
            "mens new arrivals",
            "mens new balance shoes",
            "mens nike sneakers",
            "mens sandals",
            "mens shoes",
            "mens swimwear",
            "mens t shirts",
            "mens tennis shoes adidas",
            "mens thongs",
            "mens three quarter sleeve shirts",
            "mens underwear",
            "mens versace belts",
            "mens watches"
    };


    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" + MyBenchmark.class.getSimpleName() + ".*")
                .forks(1)
                .addProfiler(GCProfiler.class)
                .build();
        new Runner(opt).run();
    }

    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testX4Performance() {
        for (String phrase : PHRASES) {
            PhraseUtils.toAscii(phrase);
        }
    }

    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testX4X1IFPerformance() {
        for (String phrase : PHRASES) {
            PhraseUtils.toAsciiIf(phrase);
        }
    }

    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testX1Performance() {
        for (String phrase : PHRASES) {
            PhraseUtils.toAscii2(phrase);
        }
    }

    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testStringBuilderPerformance() {
        for (String phrase : PHRASES) {
            PhraseUtils.toAscii3(phrase);
        }
    }

    @Warmup(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 10, time = 500, timeUnit = TimeUnit.MILLISECONDS)
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void testCharArrayPerformance() {
        for (String phrase : PHRASES) {
            PhraseUtils.toAsciiCharArray(phrase);
        }
    }
    

}
