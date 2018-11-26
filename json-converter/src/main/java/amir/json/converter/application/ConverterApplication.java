package amir.json.converter.application;

import amir.json.converter.restapi.ConverterAPI;
import amir.json.converter.service.mapper.ConverterObjectMapper;
import amir.json.converter.service.JsonGeneratorService;
import amir.json.converter.service.ObjectConstructorService;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class ConverterApplication extends Application<ConverterConfiguration> {

    public static void main(String[] args) throws Exception {
        new ConverterApplication().run(args);
    }

    public void run(ConverterConfiguration configuration, Environment env) throws Exception {
        //Register resource
        env.jersey().register(
                new AbstractBinder() {
                    @Override
                    protected void configure() {
                        bind(ConverterConfiguration.class).to(ConverterConfiguration.class);
                        bind(ConverterObjectMapper.class).to(ConverterObjectMapper.class);
                        bind(ObjectConstructorService.class).to(ObjectConstructorService.class);
                        bind(JsonGeneratorService.class).to(JsonGeneratorService.class);
                    }
                });
        env.jersey().register(ConverterAPI.class);
    }
}
