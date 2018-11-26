package amir.json.converter.application;

import io.dropwizard.Configuration;

public class ConverterConfiguration extends Configuration {
    private Long chunkSize = 10000L;

    public Long getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(Long chunkSize) {
        this.chunkSize = chunkSize;
    }
}
