import model.InputData;
import model.RateType;
import service.AmountsCalculationServiceImpl;
import service.MortgageCalculationService;
import service.MortgageCalculationServiceImpl;
import service.PrintingService;
import service.PrintingServiceImpl;
import service.RateCalculationService;
import service.RateCalculationServiceImpl;
import service.ResidualCalculationServiceImpl;
import service.TimePointServiceImpl;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        InputData inputData = new InputData()
                .withAmount(new BigDecimal("298000"))
                .withRateType(RateType.DECREASING);

        PrintingService printingService = new PrintingServiceImpl();
        RateCalculationService rateCalculationService = new RateCalculationServiceImpl(
                new TimePointServiceImpl(),
                new AmountsCalculationServiceImpl(),
                new ResidualCalculationServiceImpl()
        );

        MortgageCalculationService mortgageCalculationService = new MortgageCalculationServiceImpl(
                printingService,
                rateCalculationService
        );

        mortgageCalculationService.calculate(inputData);

    }
}