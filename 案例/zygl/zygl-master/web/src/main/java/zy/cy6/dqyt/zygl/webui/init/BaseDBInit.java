package zy.cy6.dqyt.zygl.webui.init;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import zy.cy6.dqyt.zygl.api.company.CompanyId;
import zy.cy6.dqyt.zygl.api.company.CreateCompanyCommand;
import zy.cy6.dqyt.zygl.api.orders.trades.OrderBookId;
import zy.cy6.dqyt.zygl.api.orders.trades.PortfolioId;
import zy.cy6.dqyt.zygl.api.portfolio.cash.DepositCashCommand;
import zy.cy6.dqyt.zygl.api.portfolio.stock.AddItemsToPortfolioCommand;
import zy.cy6.dqyt.zygl.api.users.CreateUserCommand;
import zy.cy6.dqyt.zygl.api.users.UserId;
import zy.cy6.dqyt.zygl.query.company.ProductEntryLx;
import zy.cy6.dqyt.zygl.query.company.repositories.CompanyQueryRepository;
import zy.cy6.dqyt.zygl.query.order.OrderBookEntry;
import zy.cy6.dqyt.zygl.query.order.repositories.OrderBookQueryRepository;
import zy.cy6.dqyt.zygl.query.portfolio.PortfolioEntry;
import zy.cy6.dqyt.zygl.query.portfolio.repositories.PortfolioQueryRepository;

import java.util.List;

/**
 * Base class for all DBInit implementations
 */
public abstract class BaseDBInit implements DBInit {
    private CommandBus commandBus;
    private CompanyQueryRepository companyRepository;
    private PortfolioQueryRepository portfolioRepository;
    private OrderBookQueryRepository orderBookRepository;

    protected BaseDBInit(CommandBus commandBus, CompanyQueryRepository companyRepository, PortfolioQueryRepository portfolioRepository, OrderBookQueryRepository orderBookRepository) {
        this.commandBus = commandBus;
        this.companyRepository = companyRepository;
        this.portfolioRepository = portfolioRepository;
        this.orderBookRepository = orderBookRepository;
    }

    @Override
    public void createItems() {
        initializeDB();

        UserId buyer1 = createuser("Buyer One", "buyer1");
        UserId buyer2 = createuser("Buyer two", "buyer2");
        UserId buyer3 = createuser("Buyer three", "buyer3");
        UserId buyer4 = createuser("Buyer four", "buyer4");
        UserId buyer5 = createuser("Buyer five", "buyer5");
        UserId buyer6 = createuser("Buyer six", "buyer6");

        createCompanies(buyer1);

        addMoney(buyer1, 100000);
        addItems(buyer2, "Philips", 10000l);
        addMoney(buyer3, 100000);
        addItems(buyer4, "Shell", 10000l);
        addMoney(buyer5, 100000);
        addItems(buyer6, "Bp", 10000l);

        additionalDBSteps();
    }

    public void depositMoneyToPortfolio(String portfolioIdentifier, long amountOfMoney) {
        DepositCashCommand command =
                new DepositCashCommand(new PortfolioId(portfolioIdentifier), amountOfMoney);
        commandBus.dispatch(new GenericCommandMessage<>(command));
    }

    UserId createuser(String longName, String userName) {
        UserId userId = new UserId();
        CreateUserCommand createUser = new CreateUserCommand(userId, longName, userName, userName);
        commandBus.dispatch(new GenericCommandMessage<>(createUser));
        return userId;
    }

    void createCompanies(UserId userIdentifier) {
        CreateCompanyCommand command = new CreateCompanyCommand(new CompanyId(), userIdentifier, "Philips", 1000, 10000);
        commandBus.dispatch(new GenericCommandMessage<>(command));

        command = new CreateCompanyCommand(new CompanyId(), userIdentifier, "Shell", 500, 5000);
        commandBus.dispatch(new GenericCommandMessage<>(command));

        command = new CreateCompanyCommand(new CompanyId(), userIdentifier, "Bp", 15000, 100000);
        commandBus.dispatch(new GenericCommandMessage<>(command));
    }

    void addMoney(UserId buyer1, long amount) {
        PortfolioEntry portfolioEntry = portfolioRepository.findByUserIdentifier(buyer1.toString());
        depositMoneyToPortfolio(portfolioEntry.getIdentifier(), amount);
    }

    void addItems(UserId user, String companyName, long amount) {
        PortfolioEntry portfolioEntry = portfolioRepository.findByUserIdentifier(user.toString());
        OrderBookEntry orderBookEntry = obtainOrderBookByCompanyName(companyName);
        AddItemsToPortfolioCommand command = new AddItemsToPortfolioCommand(
                new PortfolioId(portfolioEntry.getIdentifier()),
                new OrderBookId(orderBookEntry.getIdentifier()),
                amount);
        commandBus.dispatch(new GenericCommandMessage<>(command));
    }

    OrderBookEntry obtainOrderBookByCompanyName(String companyName) {
        Iterable<ProductEntryLx> companyEntries = companyRepository.findAll();
        for (ProductEntryLx entry : companyEntries) {
            if (entry.getName().equals(companyName)) {
                List<OrderBookEntry> orderBookEntries = orderBookRepository
                        .findByCompanyIdentifier(entry.getIdentifier());

                return orderBookEntries.get(0);
            }
        }
        throw new DBInitException("Problem initializing, could not find company with required name.");
    }

    abstract void initializeDB();

    abstract void additionalDBSteps();
}
