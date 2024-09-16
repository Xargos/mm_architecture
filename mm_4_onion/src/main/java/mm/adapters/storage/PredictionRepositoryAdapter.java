package mm.adapters.storage;

import mm.adapters.storage.entity.PredictionEntity;
import mm.ports.out.PredictionRepositoryPortOut;

public class PredictionRepositoryAdapter implements PredictionRepositoryPortOut {

    @Override public void save(PredictionDto predictionDto) {
        this.save(new PredictionEntity(
            null,
            predictionDto.prediction(),
            predictionDto.timestamp()
        ));
    }
    private void save(PredictionEntity predictionEntity) {

    }

}
