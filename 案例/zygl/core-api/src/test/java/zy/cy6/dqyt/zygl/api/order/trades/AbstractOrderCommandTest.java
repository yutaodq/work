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

package zy.cy6.dqyt.zygl.api.order.trades;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

import zy.cy6.dqyt.zygl.api.orders.trades.OrderBookId;
import zy.cy6.dqyt.zygl.api.orders.trades.OrderId;
import zy.cy6.dqyt.zygl.api.orders.trades.PortfolioId;
import zy.cy6.dqyt.zygl.api.orders.trades.TransactionId;

import javax.validation.constraints.Min;

/**
 * <p>Abstract parent class for all commands that are order related.</p>
 *
 * @author Allard Buijze
 */
public abstract class AbstractOrderCommandTest {

    private PortfolioId portfolioId;
    @TargetAggregateIdentifier
    private OrderBookId orderBookId;
    private TransactionId transactionId;
    @Min(0)
    private long tradeCount;
    @Min(0)
    private long itemPrice;
    private OrderId orderId;

    protected AbstractOrderCommandTest(OrderId orderId, PortfolioId portfolioId, OrderBookId orderBookId,
                                   TransactionId transactionId, long tradeCount, long itemPrice) {
        this.portfolioId = portfolioId;
        this.orderBookId = orderBookId;
        this.tradeCount = tradeCount;
        this.itemPrice = itemPrice;
        this.transactionId = transactionId;
        this.orderId = orderId;
    }

    public PortfolioId getPortfolioId() {
        return portfolioId;
    }

    public OrderBookId getOrderBookId() {
        return orderBookId;
    }

    public TransactionId getTransactionId() {
        return transactionId;
    }

    public long getTradeCount() {
        return tradeCount;
    }

    public long getItemPrice() {
        return itemPrice;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
