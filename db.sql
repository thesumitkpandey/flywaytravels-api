--Master table for storign the airports record
CREATE TABLE IF NOT EXISTS public.airports (
  id BIGSERIAL PRIMARY KEY,
  iata_code VARCHAR(20) NOT NULL,               -- DEL
  city_code VARCHAR(20),                        -- DEL
  country_code VARCHAR(20),                     -- IN
  state_code VARCHAR(20),                       -- DL
  region_code VARCHAR(20),                  -- ASIA
  airport_name VARCHAR(400) NOT NULL,               -- INDIRA GANDHI INTL
  city_name VARCHAR(400) NOT NULL,                  -- DELHI
  country_name VARCHAR(400) NOT NULL,               -- INDIA
  latitude DOUBLE PRECISION,                      --
  longitude DOUBLE PRECISION,
  timezone_offset VARCHAR(10),              -- +05:30
  CONSTRAINT uq_airports_iata UNIQUE (iata_code)
);
