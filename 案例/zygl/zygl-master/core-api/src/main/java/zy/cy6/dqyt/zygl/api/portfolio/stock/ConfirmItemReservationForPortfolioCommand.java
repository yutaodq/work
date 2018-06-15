/*
 * Copyright (c) 2010-2012. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package zy.cy6.dqyt.zygl.api.portfolio.stock;

import zy.cy6.dqyt.zygl.api.orders.trades.OrderBookId;
import zy.cy6.dqyt.zygl.api.orders.trades.PortfolioId;
import zy.cy6.dqyt.zygl.api.orders.trades.TransactionId;

/**
 * Confirm the reserved items belonging to OrderBook of the provided identifier for the Portfolio of the provided
 * identifier.
 *
 * @author Jettro Coenradie
 */
public class ConfirmItemReservationForPortfolioCommand {

    private PortfolioId portfolioIdentifier;
    private OrderBookId orderBookIdentifier;
    private TransactionId transactionIdentifier;
    private long amountOfItemsToConfirm;

    public ConfirmItemReservationForPortfolioCommand(PortfolioId portfolioIdentifier,
                                                     OrderBookId orderBookIdentifier,
                                                     TransactionId transactionIdentifier,
                                                     long amountOfItemsToConfirm) {
        this.portfolioIdentifier = portfolioIdentifier;
        this.orderBookIdentifier = orderBookIdentifier;
        this.transactionIdentifier = transactionIdentifier;
        this.amountOfItemsToConfirm = amountOfItemsToConfirm;
    }

    public long getAmountOfItemsToConfirm() {
        return amountOfItemsToConfirm;
    }

    public OrderBookId getOrderBookIdentifier() {
        return orderBookIdentifier;
    }

    public PortfolioId getPortfolioIdentifier() {
        return portfolioIdentifier;
    }

    public TransactionId getTransactionIdentifier() {
        return transactionIdentifier;
    }
}
