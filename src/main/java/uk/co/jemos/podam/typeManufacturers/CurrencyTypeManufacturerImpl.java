package uk.co.jemos.podam.typeManufacturers;

import uk.co.jemos.podam.api.AttributeMetadata;
import uk.co.jemos.podam.api.DataProviderStrategy;
import uk.co.jemos.podam.api.PodamUtils;
import uk.co.jemos.podam.common.ManufacturingContext;
import uk.co.jemos.podam.common.PodamConstants;

import java.time.ZoneId;
import java.util.Currency;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default {@link java.util.Currency} type manufacturer.
 *
 * @author liam on 02/01/2024.
 * @since 8.0.1.RELEASE
 */
public class CurrencyTypeManufacturerImpl extends AbstractTypeManufacturer<Currency> {
    /**
     * {@inheritDoc}
     */
    @Override
    public Currency getType(DataProviderStrategy strategy, AttributeMetadata attributeMetadata, ManufacturingContext manufacturingCtx) {

        Set<Currency> currencies = Currency.getAvailableCurrencies();
        Integer index = PodamUtils.getIntegerInRange(0, currencies.size());

        int i = 0;
        for (Currency currency : currencies) {
            if (index.equals(i++)) {
                return currency;
            }
        }

        return Currency.getInstance(Locale.ENGLISH);
    }
}
