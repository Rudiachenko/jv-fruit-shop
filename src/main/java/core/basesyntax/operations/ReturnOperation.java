package core.basesyntax.operations;

import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReturnOperation implements Operation {
    private final Map<String, Integer> stockBalance = Storage.getStockBalance();

    @Override
    public void provideOperation(String fruit, int quantity, String date) {
        if (stockBalance.containsKey(fruit)) {
            int fruitsAmount = stockBalance.get(fruit);
            stockBalance.merge(fruit, fruitsAmount, (a, b) -> b + quantity);
        } else {
            throw new RuntimeException("You did not buy this fruit from us.");
        }
    }
}
