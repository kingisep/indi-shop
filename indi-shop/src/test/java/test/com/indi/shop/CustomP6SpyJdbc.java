package test.com.indi.shop;

import java.sql.SQLException;

import org.hibernate.engine.jdbc.internal.BasicFormatterImpl;

import com.p6spy.engine.common.StatementInformation;
import com.p6spy.engine.event.JdbcEventListener;
import com.p6spy.engine.logging.LoggingEventListener;
import com.p6spy.engine.logging.P6LogOptions;
import com.p6spy.engine.spy.P6Factory;
import com.p6spy.engine.spy.P6LoadableOptions;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import com.p6spy.engine.spy.option.P6OptionsRepository;

public class CustomP6SpyJdbc extends LoggingEventListener implements P6Factory, MessageFormattingStrategy {
    public static final CustomP6SpyJdbc INSTANCE = new CustomP6SpyJdbc();
    private final BasicFormatterImpl basicFormatterImpl = new BasicFormatterImpl();

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return formatQueryHibernateStyle(sql, elapsed);
    }

    private String formatQueryHibernateStyle(String query, long elapsed) {
        if (query.isEmpty()) {
            return "";
        }
        String queryTemp = basicFormatterImpl.format(query);
        queryTemp = queryTemp.replaceAll("=", " = ");
        queryTemp = queryTemp.replaceAll("< =", "<=");
        queryTemp = queryTemp.replaceAll("> =", ">=");
        return "----------------------------" + "\n " + queryTemp + "\n QUERY PERFORMANCE(MS): " + elapsed;
    }

    @Override
    public void onAfterExecuteBatch(StatementInformation statementInformation, long timeElapsedNanos, int[] updateCounts, SQLException e) {
        // do nothing, we don't want to print the same create/update twice
    }

    @Override
    public P6LoadableOptions getOptions(P6OptionsRepository optionsRepository) {
        return new P6LogOptions(optionsRepository);
    }

    @Override
    public JdbcEventListener getJdbcEventListener() {
        return INSTANCE;
    }

}
