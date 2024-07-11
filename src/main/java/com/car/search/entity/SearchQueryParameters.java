package com.car.search.entity;

public class SearchQueryParameters {

    public int length;

    public int weight;

    public int velocity;

    public String color;



    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static final class Builder {
        private int length;
        private int weight;
        private int velocity;
        private String color;

        private Builder() {
        }

        public static Builder aSearchQueryParameters() {
            return new Builder();
        }

        public static SearchQueryParameters buildEmpty() {
            return aSearchQueryParameters().build();
        }

        public Builder withLength(int length) {
            this.length = length;
            return this;
        }

        public Builder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder withVelocity(int velocity) {
            this.velocity = velocity;
            return this;
        }

        public Builder withColor(String color) {
            this.color = color;
            return this;
        }

        public SearchQueryParameters build() {
            SearchQueryParameters searchQueryParameters = new SearchQueryParameters();
            searchQueryParameters.setLength(length);
            searchQueryParameters.setWeight(weight);
            searchQueryParameters.setVelocity(velocity);
            searchQueryParameters.setColor(color);
            return searchQueryParameters;
        }
    }
}
