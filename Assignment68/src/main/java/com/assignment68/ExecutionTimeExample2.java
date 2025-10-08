package com.assignment68;

import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.binder.jvm.JvmGcMetrics;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;
public class ExecutionTimeExample2 {
   public static void main(String[] args) {
    PrometheusMeterRegistry registry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
       Timer timer = registry.timer("application.process.time");
timer.record(()->{
 // Code to measure
   for (int i = 0; i < 1000000; i++) {
       Math.sqrt(i);
   }
});
System.out.println(registry.scrape());
   }
}