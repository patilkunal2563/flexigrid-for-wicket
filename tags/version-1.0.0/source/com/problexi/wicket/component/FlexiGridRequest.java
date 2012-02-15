package com.problexi.wicket.component;

import com.problexi.common.dao.IFilter;
import com.problexi.common.dao.ILimit;
import com.problexi.common.dao.IOrder;

import java.io.Serializable;

/**
 * Flexigrid Request.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 */
public final class FlexiGridRequest {
    /**
     * Request's Page Number.
     *
     * @since 1.0.0
     */
    private final int pageNumber;
    /**
     * Request's Filter.
     *
     * @since 1.0.0
     */
    private final IFilter filter;
    /**
     * Request's Limit.
     *
     * @since 1.0.0
     */
    private final ILimit limit;
    /**
     * Request's Order.
     *
     * @since 1.0.0
     */
    private final IOrder order;

    /**
     * Default Constructor.
     *
     * @param pageNumber A page number.
     * @param filter     A filter.
     * @param limit      A limit.
     * @param order      An order.
     * @since 1.0.0
     */
    public FlexiGridRequest(int pageNumber, IFilter filter, ILimit limit, IOrder order) {
        this.pageNumber = pageNumber;
        this.filter = filter;
        this.limit = limit;
        this.order = order;
    }

    /**
     * Get Request's Page Number.
     *
     * @return The request's page number.
     * @since 1.0.0
     */
    public int getPageNumber() {
        return this.pageNumber;
    }

    /**
     * Get Request's Filter.
     *
     * @return The request's filter.
     * @since 1.0.0
     */
    public IFilter getFilter() {
        return this.filter;
    }

    /**
     * Get Request's Limit.
     *
     * @return The request's limit.
     * @since 1.0.0
     */
    public ILimit getLimit() {
        return this.limit;
    }

    /**
     * Get Request's Order.
     *
     * @return The request's order.
     * @since 1.0.0
     */
    public IOrder getOrder() {
        return this.order;
    }

    /**
     * Determine if Request's Filter is Set.
     *
     * @return A boolean true if the request's filter is set. A boolean false otherwise.
     * @since 1.0.0
     */
    public boolean isFilterSet() {
        return this.filter != null;
    }

    /**
     * Determine if Request's Limit is Set.
     *
     * @return A boolean true if the request's limit is set. A boolean false otherwise.
     * @since 1.0.0
     */
    public boolean isLimitSet() {
        return this.limit != null;
    }

    /**
     * Determine if Request's Order is Set.
     *
     * @return A boolean true if the request's order is set. A boolean false otherwise.
     * @since 1.0.0
     */
    public boolean isOrderSet() {
        return this.order != null;
    }
}