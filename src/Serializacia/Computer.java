package Serializacia;

import java.io.Serializable;

class Computer implements Serializable {
        private String name;
        private int memory;
        private double weight;
    public Computer(String name, int memory, double weight){
            this.name = name;
            this.memory = memory;
            this.weight = weight;
        }

        public String getName () {
            return name;
        }

        public double getWeight () {
            return weight;
        }

        public int getMemory () {
            return memory;
        }
    }

