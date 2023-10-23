-- db/changelog/sql/001-create-product-tables.sql

-- Liquibase formatted SQL

-- ChangeSet
-- ChangeSet author: Trung Doan
-- ChangeSet id: 001

CREATE TABLE IF NOT EXISTS anonymous_url_access
(
    id character varying(255) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS resource_action
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    action character varying(255),
    request_method character varying(255),
    resource_type character varying(255),
    url character varying(255),
    CONSTRAINT resource_action_request_method_check CHECK (request_method::text = ANY (ARRAY['GET'::character varying, 'HEAD'::character varying, 'POST'::character varying, 'PUT'::character varying, 'PATCH'::character varying, 'DELETE'::character varying, 'OPTIONS'::character varying, 'TRACE'::character varying]::text[]))
);

CREATE TABLE IF NOT EXISTS internal_service_config
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    activated boolean NOT NULL,
    api_key character varying(255) NOT NULL,
    created_date timestamp(6) with time zone,
    last_modified_date timestamp(6) with time zone,
    service_name character varying(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS permission
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    action character varying(255) NOT NULL,
    control character varying(255) NOT NULL,
    request_method character varying(255),
    resource_type character varying(255) NOT NULL,
    role_id character varying(255) NOT NULL,
    url character varying(255),
    CONSTRAINT permission_control_check CHECK (control::text = ANY (ARRAY['ALLOWED'::character varying, 'DENIED'::character varying, 'ALLOWED_SPECIFIC_RESOURCES'::character varying, 'DENIED_SPECIFIC_RESOURCES'::character varying, 'MANUAL_CHECK'::character varying]::text[])),
    CONSTRAINT permission_request_method_check CHECK (request_method::text = ANY (ARRAY['GET'::character varying, 'HEAD'::character varying, 'POST'::character varying, 'PUT'::character varying, 'PATCH'::character varying, 'DELETE'::character varying, 'OPTIONS'::character varying, 'TRACE'::character varying]::text[]))
);

CREATE TABLE IF NOT EXISTS rate_source
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    name character varying(255),
    note character varying(255),
    type character varying(255),
    CONSTRAINT rate_source_type_check CHECK (type::text = ANY (ARRAY['INTEREST'::character varying, 'WITHHOLDING_TAX'::character varying, 'VALUE_ADDED_TAX'::character varying]::text[]))
);

CREATE TABLE IF NOT EXISTS currency
(
    id character varying(255) PRIMARY KEY,
    name character varying(255),
    symbol character varying(255)
);

CREATE TABLE IF NOT EXISTS product_category
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    name character varying(255),
    type character varying(255),
    CONSTRAINT product_category_type_check CHECK (type::text = ANY (ARRAY['DEPOSIT_CATEGORY'::character varying, 'LOAN_CATEGORY'::character varying, 'DEPOSIT_TYPE'::character varying, 'LOAN_TYPE'::character varying, 'GL_TYPE'::character varying, 'CRYPTO_TYPE'::character varying]::text[]))
);

CREATE TABLE IF NOT EXISTS holiday
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    description character varying(255),
    holiday_date date,
    repeat_yearly boolean
);

CREATE TABLE IF NOT EXISTS branch
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    city character varying(255),
    country character varying(255),
    email character varying(255),
    name character varying(255),
    parent_branch_id character varying(255),
    phone_number character varying(255),
    state character varying(255),
    street_address_line_1 character varying(255),
    zip_postal_code character varying(255)
);

CREATE TABLE IF NOT EXISTS crypto_product
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    activated boolean NOT NULL,
    allow_arbitrary_fees boolean NOT NULL,
    category character varying(255) NOT NULL,
    currency character varying(255) NOT NULL,
    description character varying(255),
    name character varying(255),
    new_account_setting jsonb NOT NULL,
    product_availabilities jsonb NOT NULL,
    product_fees jsonb,
    show_inactive_fees boolean NOT NULL,
    type character varying(255),
    crypto_address character varying(255),
    crypto_private character varying(255)
);

CREATE TABLE IF NOT EXISTS deposit_product
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    activated boolean NOT NULL,
    allow_arbitrary_fees boolean NOT NULL,
    category character varying(255) NOT NULL,
    currency character varying(255) NOT NULL,
    description character varying(255),
    name character varying(255),
    new_account_setting jsonb NOT NULL,
    product_availabilities jsonb NOT NULL,
    product_fees jsonb,
    show_inactive_fees boolean NOT NULL,
    type character varying(255),
    allow_deposit_after_maturity_date boolean,
    allow_overdrafts boolean,
    days_to_set_to_dormant integer,
    default_term_length double precision,
    deposit_limits jsonb,
    early_closure_period jsonb,
    interest_rate jsonb,
    max_overdraft_limit double precision,
    max_term_length double precision,
    min_term_length double precision,
    overdrafts_interest jsonb,
    overdrafts_under_credit_arrangement_managed character varying(255),
    supported_currencies jsonb,
    term_unit character varying(255),
    withdrawal_limit jsonb,
    CONSTRAINT deposit_product_overdrafts_under_credit_arrangement_manag_check CHECK (overdrafts_under_credit_arrangement_managed::text = ANY (ARRAY['REQUIRED'::character varying, 'NO'::character varying, 'OPTIONAL'::character varying]::text[])),
    CONSTRAINT deposit_product_term_unit_check CHECK (term_unit::text = ANY (ARRAY['DAY'::character varying, 'WEEK'::character varying, 'MONTH'::character varying]::text[]))
);

CREATE TABLE IF NOT EXISTS exchange_rate
(
    id character varying(255) NOT NULL,
    buy_rate double precision,
    name character varying(255),
    sell_rate double precision
);

CREATE TABLE IF NOT EXISTS gl_product
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    activated boolean NOT NULL,
    allow_arbitrary_fees boolean NOT NULL,
    category character varying(255) NOT NULL,
    currency character varying(255) NOT NULL,
    description character varying(255),
    name character varying(255),
    new_account_setting jsonb NOT NULL,
    product_availabilities jsonb NOT NULL,
    product_fees jsonb,
    show_inactive_fees boolean NOT NULL,
    type character varying(255),
    supported_currencies jsonb
);

CREATE TABLE IF NOT EXISTS loan_product
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    activated boolean NOT NULL,
    allow_arbitrary_fees boolean NOT NULL,
    category character varying(255) NOT NULL,
    currency character varying(255) NOT NULL,
    description character varying(255),
    name character varying(255),
    new_account_setting jsonb NOT NULL,
    product_availabilities jsonb NOT NULL,
    product_fees jsonb,
    show_inactive_fees boolean NOT NULL,
    type character varying(255),
    arrears_setting jsonb NOT NULL,
    cap_charges boolean NOT NULL,
    close_dormant_accounts boolean NOT NULL,
    interest_rate jsonb NOT NULL,
    loan_default double precision NOT NULL,
    loan_max double precision NOT NULL,
    loan_min double precision NOT NULL,
    lock_arrears_accounts boolean NOT NULL,
    penalty_setting jsonb NOT NULL,
    percent_collateral double precision,
    percent_guarantors double precision,
    repayment_collection jsonb NOT NULL,
    repayment_scheduling jsonb NOT NULL,
    under_credit_arrangement_managed character varying(255),
    CONSTRAINT loan_product_under_credit_arrangement_managed_check CHECK (under_credit_arrangement_managed::text = ANY (ARRAY['REQUIRED'::character varying, 'NO'::character varying, 'OPTIONAL'::character varying]::text[]))
);

CREATE TABLE IF NOT EXISTS organization
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    city character varying(255),
    country character varying(255),
    currency character varying(255),
    decimal_mark character varying(255),
    email character varying(255),
    icon_url character varying(255),
    local_date_format character varying(255),
    local_date_time_format character varying(255),
    logo_url character varying(255),
    name character varying(255),
    non_working_days jsonb,
    phone_number character varying(255),
    state character varying(255),
    street_address_line_1 character varying(255),
    timezone character varying(255),
    zip_postal_code character varying(255)
);

CREATE TABLE IF NOT EXISTS rate
(
    id character varying(255) DEFAULT gen_random_uuid()::character varying(255) PRIMARY KEY,
    note character varying(255),
    rate_value double precision,
    type character varying(255),
    valid_from timestamp(6) with time zone,
    rate_source_id character varying(255),
    CONSTRAINT fkg77aavhjtgcybvjt5pe70hbw2 FOREIGN KEY (rate_source_id)
        REFERENCES rate_source (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT rate_type_check CHECK (type::text = ANY (ARRAY['INTEREST'::character varying, 'WITHHOLDING_TAX'::character varying, 'VALUE_ADDED_TAX'::character varying]::text[]))
);
-- /ChangeSet