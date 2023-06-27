package tools;
/*
 * Copyright (c) 2013, Oskar Veerhoek
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * The views and conclusions contained in the software and documentation are those
 * of the authors and should not be interpreted as representing official policies,
 * either expressed or implied, of the FreeBSD Project.
 */

import org.lwjgl.util.vector.Vector3f;


import java.io.*;

    public class OBJLoader {


    private static Vector3f parseVertex(String line) {
        String[] xyz = line.split(" ");
        float x = Float.valueOf(xyz[1]);
        float y = Float.valueOf(xyz[2]);
        float z = Float.valueOf(xyz[3]);
        return new Vector3f(x, y, z);
    }

    private static Vector3f parseNormal(String line) {
        String[] xyz = line.split(" ");
        float x = Float.valueOf(xyz[1]);
        float y = Float.valueOf(xyz[2]);
        float z = Float.valueOf(xyz[3]);
        return new Vector3f(x, y, z);
    }

    private static Model.Face parseFace(boolean hasNormals, String line) {
        String[] faceIndices = line.split(" ");
        int[] vertexIndicesArray = {Integer.parseInt(faceIndices[1].split("/")[0]),
                Integer.parseInt(faceIndices[2].split("/")[0]), Integer.parseInt(faceIndices[3].split("/")[0])};
        if (hasNormals) {
            int[] normalIndicesArray = new int[3];
            normalIndicesArray[0] = Integer.parseInt(faceIndices[1].split("/")[2]);
            normalIndicesArray[1] = Integer.parseInt(faceIndices[2].split("/")[2]);
            normalIndicesArray[2] = Integer.parseInt(faceIndices[3].split("/")[2]);
            return new Model.Face(vertexIndicesArray, normalIndicesArray);
        } else {
            return new Model.Face((vertexIndicesArray));
        }
    }

    public static Model loadModel(File f) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            Model m = new Model();
            String line;
            while ((line = reader.readLine()) != null) {
                String prefix = line.split(" ")[0];
                System.out.println(line);
                if (prefix.equals("#")) {
                    continue;
                } else if (prefix.equals("v")) {
                    m.getVertices().add(parseVertex(line));
                } else if (prefix.equals("vn")) {
                    m.getNormals().add(parseNormal(line));
                } else if (prefix.equals("f")) {
                    m.getFaces().add(parseFace(m.hasNormals(), line));
                }
            }
            reader.close();
            return m;
    }

}