package com.zm.rmqexample.configuration;


public class RMQExampleConfiguration {
    public enum Channel {
        TEST("test"),
        PROD("prod");

        private final String value;
        private Channel(String value) {
                this.value = value;
            }

        public String getValue() {
            return value;
        }
    }

    public enum Host {
        TEST("localhost"),
        PROD("localhost");

        private final String value;
        private Host(String value) {
                this.value = value;
            }

        public String getValue() {
            return value;
        }
    }
}