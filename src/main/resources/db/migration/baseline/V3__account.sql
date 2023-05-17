CREATE TABLE IF NOT EXISTS account
(
    id                     uuid PRIMARY KEY,
    person_id              uuid REFERENCES person (id),
    currency               text           NOT NULL,
    balance                decimal(15, 2) NOT NULL DEFAULT 0,
    custom_attributes_json jsonb
);

CREATE INDEX account_currency ON account (currency);
CREATE INDEX account_balance ON account (balance);
CREATE INDEX IF NOT EXISTS account_custom_attributes
    ON account USING gin (custom_attributes_json);
