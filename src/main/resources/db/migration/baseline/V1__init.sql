CREATE TABLE IF NOT EXISTS person
(
    id      uuid PRIMARY KEY,
    name    text NOT NULL,
    email   text,
    address text NOT NULL,
    phone   text NOT NULL UNIQUE,
    custom_attributes_json jsonb
);

CREATE INDEX person_name ON person (name);
CREATE INDEX person_email ON person (email) WHERE email IS NOT NULL;
CREATE INDEX IF NOT EXISTS person_custom_attributes
    ON person USING gin (custom_attributes_json);
