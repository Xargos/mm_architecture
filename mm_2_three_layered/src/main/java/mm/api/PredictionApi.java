package mm.api;

import lombok.RequiredArgsConstructor;
import mm.api.dto.PredictionRequest;
import mm.api.dto.PredictionResponse;
import mm.service.PredictionService;
import mm.service.model.Instrument;

@RequiredArgsConstructor
public class PredictionApi {
    private final PredictionService predictionService;

    public PredictionResponse predictionEndpoint(PredictionRequest predictionRequest) {

        var instrument = new Instrument(predictionRequest.instrumentName());
        var prediction = predictionService.predict(instrument);

        return new PredictionResponse(prediction.value());
    }
}
