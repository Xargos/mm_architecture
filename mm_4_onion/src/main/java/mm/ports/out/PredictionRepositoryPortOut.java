package mm.ports.out;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public interface PredictionRepositoryPortOut {

    record InstrumentDto(String name) {
    }
    record PredictionDto(
        InstrumentDto instrumentDto,
        BigDecimal prediction,
        Instant timestamp) {
    }
sCEN
    void save(PredictionDto predictionDto);

    List<PredictionDto> findPredictions(InstrumentDto instrumentDto);
}
