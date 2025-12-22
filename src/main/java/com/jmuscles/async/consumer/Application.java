package com.jmuscles.async.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
*/
/**
 * Hello world!
 *
 */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		/*
		 * SdkTracerProvider tracerProvider = SdkTracerProvider.builder().build();
		 * OpenTelemetrySdk.builder().setTracerProvider(tracerProvider).
		 * buildAndRegisterGlobal();
		 */

		SpringApplication.run(Application.class, args);
	}

}
