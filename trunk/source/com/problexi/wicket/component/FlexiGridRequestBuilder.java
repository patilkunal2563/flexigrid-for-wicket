package com.problexi.wicket.component;

import com.problexi.common.dao.IFilter;
import com.problexi.common.dao.ILimit;
import com.problexi.common.dao.IOrder;
import com.problexi.common.dao.standard.factory.FilterFactory;
import com.problexi.common.dao.standard.factory.LimitFactory;
import com.problexi.common.dao.standard.factory.OrderFactory;
import org.apache.wicket.request.IRequestParameters;
import org.apache.wicket.request.cycle.RequestCycle;
import org.apache.wicket.util.string.StringValue;

/**
 * Flexigrid Request Builder.
 *
 * @author Ahmed Garhy
 * @version 1.0.0
 * @since 1.0.0
 */
final class FlexiGridRequestBuilder {
    /**
     * Singleton Instance.
     */
    private static final FlexiGridRequestBuilder INSTANCE = new FlexiGridRequestBuilder();

    /**
     * Create a New Flexigrid Request Builder.
     *
     * @return A flexigrid request builder.
     * @since 1.0.0
     */
    public static FlexiGridRequestBuilder newInstance() {
        return FlexiGridRequestBuilder.INSTANCE;
    }

    /**
     * Get Flexigrid Request.
     *
     * @return A flexigrid request.
     * @since 1.0.0
     */
    public FlexiGridRequest getRequest() {
        IFilter filter = this.helpCreateFilter();
        ILimit limit = this.helpCreateLimit();
        IOrder order = this.helpCreateOrder();
        int pageNumber = this.helpGetPageNumber();

        return new FlexiGridRequest(pageNumber, filter, limit, order);
    }

    /**
     * Help Create Request's Filter.
     *
     * @return A filter. A Null Reference indicates that the request has no filter.
     * @since 1.0.0
     */
    private IFilter helpCreateFilter() {
        String filterIdentifier = this.helpGetFilterIdentifier();
        String filterValue = this.helpGetFilterValue();

        // Create Filter.
        //
        // Only creates a filter if the filter value parameter is not a Null Reference. It's worth noting that
        // Flexigrid might set a value for the filter identifier parameter even if the filter value parameter is a
        // Null Reference.
        IFilter filter = null;
        if (filterValue != null) {
            filter = FilterFactory.newContainingFilter(filterIdentifier, filterValue);
        }

        return filter;
    }

    /**
     * Help Create Limit.
     *
     * @return A limit.
     * @since 1.0.0
     */
    private ILimit helpCreateLimit() {
        int pageNumber = this.helpGetPageNumber();
        int recordsPerPage = this.helpGetRecordsPerPage();

        return LimitFactory.forPage(pageNumber, recordsPerPage);
    }

    /**
     * Help Create Order.
     *
     * @return An order. A Null Reference indicates that the request has no order.
     * @since 1.0.0
     */
    private IOrder helpCreateOrder() {
        String identifier = this.helpGetOrderIdentifier();
        String directionIdentifier = this.helpGetOrderDirection();

        // Create Filter.
        //
        // Only creates an order if the order identifier parameter is not a Null Reference.
        IOrder order = null;
        if (directionIdentifier != null) {
            order = OrderFactory.fromDirectionIdentifier(identifier, directionIdentifier);
        }

        return order;
    }

    /**
     * Help Get Filter Identifier.
     *
     * @return The request's filter identifier. A Null Reference indicates that the request has no filter identifier.
     * @since 1.0.0
     */
    private String helpGetFilterIdentifier() {
        StringValue filterIdentifierParameter = this.helpGetParameter("qtype");

        // Get Filter Identifier.
        //
        // Resets the filter identifier to a Null Reference if it is an empty string. Flexigrid will set the filter
        // identifier parameter to an empty string if it has no value.
        String filterIdentifier = filterIdentifierParameter.toString();
        if (filterIdentifier.equals("")) {
            filterIdentifier = null;
        }

        return filterIdentifier;
    }

    /**
     * Help Get Filter Value.
     *
     * @return The request's filter value. A Null Reference indicates that the request has no filter value.
     * @since 1.0.0
     */
    private String helpGetFilterValue() {
        StringValue filterValueParameter = this.helpGetParameter("query");

        // Get Filter Value.
        //
        // Resets the filter value to a Null Reference if it is an empty string. Flexigrid will set the filter value
        // parameter to an empty string if it has no value.
        String filterValue = filterValueParameter.toString();
        if (filterValue.equals("")) {
            filterValue = null;
        }

        return filterValue;
    }

    /**
     * Help Get Order Direction.
     *
     * @return The request's order direction. A Null Reference indicates that the request has no order direction.
     * @since 1.0.0
     */
    private String helpGetOrderDirection() {
        StringValue orderDirectionParameter = this.helpGetParameter("sortorder");

        // Get Order Direction.
        //
        // Resets the order direction to a Null Reference if it is a String equal to "undefined". Flexigrid will set
        // the order direction parameter to "undefined" if it has no value.
        String orderDirection = orderDirectionParameter.toString();
        if (orderDirection.equals("undefined")) {
            orderDirection = null;
        }

        return orderDirection;
    }

    /**
     * Help Get Order Identifier.
     *
     * @return The request's order identifier. A Null Reference indicates that the request has no order identifier.
     * @since 1.0.0
     */
    private String helpGetOrderIdentifier() {
        StringValue orderIdentifierParameter = this.helpGetParameter("sortname");

        // Get Order Identifier.
        //
        // Resets the order identifier to a Null Reference if it is a String equal to "undefined". Flexigrid will set
        // the order identifier parameter to "undefined" if it has no value.
        String orderIdentifier = orderIdentifierParameter.toString();
        if (orderIdentifier.equals("undefined")) {
            orderIdentifier = null;
        }

        return orderIdentifier;
    }

    /**
     * Help Get Request's Page Number.
     *
     * @return The request's page number.
     * @since 1.0.0
     */
    private int helpGetPageNumber() {
        StringValue pageNumberParameter = this.helpGetParameter("page");
        return pageNumberParameter.toInt();
    }

    /**
     * Help Get a Request Parameter.
     *
     * @param parameterName A parameter's name.
     * @return A parameter identified by the given name.
     * @since 1.0.0
     */
    private StringValue helpGetParameter(String parameterName) {
        IRequestParameters requestParameters = RequestCycle.get().getRequest().getRequestParameters();
        return requestParameters.getParameterValue(parameterName);
    }

    /**
     * Help Get Records Per Page Parameter.
     *
     * @return The request's records per page.
     * @since 1.0.0
     */
    private int helpGetRecordsPerPage() {
        StringValue recordsPerPageParameter = this.helpGetParameter("rp");
        return recordsPerPageParameter.toInt();
    }
}