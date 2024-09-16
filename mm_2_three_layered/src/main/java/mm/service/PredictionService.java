package mm.service;

import java.math.BigDecimal;
import java.time.Instant;
import lombok.RequiredArgsConstructor;
import mm.infrastructure.PredictionRepository;
import mm.infrastructure.entity.PredictionEntity;
import mm.service.model.Instrument;
import mm.service.model.Prediction;

@RequiredArgsConstructor
public class PredictionService {

    private final LocalLlmService localLlmService;
    private final PredictionRepository predictionRepository;

    public Prediction predict(Instrument instrument) {
        var query = "Predict the price of " + instrument.name();
        var result = localLlmService.inference(query);
        var prediction = new Prediction(new BigDecimal(result));
        predictionRepository.save(new PredictionEntity(
            null,
            prediction.value(),
            Instant.now()
        ));
        return prediction;
    }
}
