package co.com.bancolombia.api.config;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Componente para gestionar métricas personalizadas de la aplicación
 */
@Component
public class ApiMetrics {
    private final MeterRegistry meterRegistry;
    private final ConcurrentHashMap<String, Timer> timers = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Counter> counters = new ConcurrentHashMap<>();

    public ApiMetrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;

        // Contadores para operaciones CRUD
        registerCounter("api.users.get.count", "Número de veces que se ha obtenido un usuario");
        registerCounter("api.users.create.count", "Número de usuarios creados");
        registerCounter("api.users.update.count", "Número de usuarios actualizados");
        registerCounter("api.users.delete.count", "Número de usuarios eliminados");
        registerCounter("api.users.error.count", "Número de errores en operaciones de usuarios");

        // Timers para medir tiempos de respuesta
        registerTimer("api.users.get.time", "Tiempo de respuesta al obtener un usuario");
        registerTimer("api.users.create.time", "Tiempo de respuesta al crear un usuario");
        registerTimer("api.users.update.time", "Tiempo de respuesta al actualizar un usuario");
        registerTimer("api.users.delete.time", "Tiempo de respuesta al eliminar un usuario");
    }

    private void registerCounter(String name, String description) {
        Counter counter = Counter.builder(name)
                .description(description)
                .register(meterRegistry);
        counters.put(name, counter);
    }

    private void registerTimer(String name, String description) {
        Timer timer = Timer.builder(name)
                .description(description)
                .publishPercentiles(0.5, 0.95, 0.99)
                .register(meterRegistry);
        timers.put(name, timer);
    }

    public void incrementCounter(String name) {
        Counter counter = counters.get(name);
        if (counter != null) {
            counter.increment();
        }
    }

    public Timer.Sample startTimer() {
        return Timer.start(meterRegistry);
    }

    public void stopTimer(Timer.Sample sample, String name) {
        Timer timer = timers.get(name);
        if (timer != null && sample != null) {
            sample.stop(timer);
        }
    }

    public void recordTime(String name, long timeInMs) {
        Timer timer = timers.get(name);
        if (timer != null) {
            timer.record(timeInMs, TimeUnit.MILLISECONDS);
        }
    }
}
