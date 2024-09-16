package mm.api;

import lombok.RequiredArgsConstructor;
import mm.api.dto.PredictionRequest;
import mm.api.dto.PredictionResponse;
import mm.ports.in.PredictionPortIn;

@RequiredArgsConstructor
public class PredictionApi {
    private final PredictionPortIn predictionPortIn;

    public PredictionResponse predictionEndpoint(PredictionRequest predictionRequest) {
        var instrument = new PredictionPortIn.InstrumentDto(predictionRequest.instrumentName());
        var prediction = predictionPortIn.predict(instrument);

        return new PredictionResponse(prediction.value());
    }
}
