package org.octoosmo.pgJsonbDemo.config;

import org.hibernate.boot.model.FunctionContributions;
import org.hibernate.boot.model.FunctionContributor;
import org.hibernate.type.StandardBasicTypes;

public class SqlFunctionContributor implements FunctionContributor {
    @Override
    public void contributeFunctions(FunctionContributions functionContributions) {
        functionContributions.getFunctionRegistry()
                .registerPattern("internal_jsonb_contains",
                        "?1@>?2::jsonb",
                        functionContributions.getTypeConfiguration().getBasicTypeRegistry()
                                .resolve(StandardBasicTypes.BOOLEAN));
    }
}
