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

package zy.cy6.dqyt.zygl.api.orders.trades;


/**
 * <p>Create a new Buy Order.</p>
 *
 * @author Allard Buijze
 */
public class CreateBuyOrderCommand extends AbstractOrderCommand {

    public CreateBuyOrderCommand(OrderId orderId, PortfolioId portfolioId, OrderBookId orderBookId,
                                 TransactionId transactionId, long tradeCount, long itemPrice) {
        super(orderId, portfolioId, orderBookId, transactionId, tradeCount, itemPrice);
    }
}
