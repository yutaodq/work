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

package zy.cy6.dqyt.zygl.query.order;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jettro Coenradie
 * 交易委托账本 (Order Book, 以下简称委托账本或账本)
 */
@Entity
public class OrderBookEntry {

    @Id
    @javax.persistence.Id
    private String identifier;
    private String companyIdentifier;
    private String companyName;
    
    /*
     * 原fetch = FetchType.EAGER 出错
     * 在用JPA进行注释时，如果一个实体里要映射多个集合实体时，我们不能把两个集合的的FetchType设置为EAGER,
     * 此时只能设置为LAZY,否则会报：cannot simultaneously fetch multiple bags。
     * 或者我们也可以借助:@IndexColumn    * 
     * 
     */
    
    //卖单
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ORDERENTRY_SELL", joinColumns = @JoinColumn(name = "ORDERBOOK_ID"), inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    private List<OrderEntry> sellOrders = new ArrayList<>();

    //买单
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "ORDERENTRY_BUY", joinColumns = @JoinColumn(name = "ORDERBOOK_ID"), inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    private List<OrderEntry> buyOrders = new ArrayList<>();

    public List<OrderEntry> sellOrders() {
        return sellOrders;
    }

    public List<OrderEntry> buyOrders() {
        return buyOrders;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCompanyIdentifier() {
        return companyIdentifier;
    }

    public void setCompanyIdentifier(String companyIdentifier) {
        this.companyIdentifier = companyIdentifier;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<OrderEntry> getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(List<OrderEntry> buyOrders) {
        this.buyOrders = buyOrders;
    }

    public List<OrderEntry> getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(List<OrderEntry> sellOrders) {
        this.sellOrders = sellOrders;
    }
}
