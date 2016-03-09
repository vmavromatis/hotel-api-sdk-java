/**
 * Autogenerated code by SdkModelGenerator.
 * Do not edit. Any modification on this file will be removed automatically after project build
 *
 */
package com.hotelbeds.hotelapimodel.auto.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


import lombok.extern.slf4j.Slf4j;

/**
 * The Class SimpleTypes.
 *
 * @author Hotelbeds Accommodation and Destination Services
 */
@Slf4j
public final class SimpleTypes {
    public static final String AGES_RATEKEY_SEPARATOR = "~";
    public static final String VALUE_TOKEN = "~";
    public static final int INDEX_0 = 0;
    public static final int INDEX_1 = 1;
    public static final int INDEX_2 = 2;
    public static final String RATE_KEY_SEPARATOR = "|";
    public static final String ROOM_SEPARATOR = ".";
    public static final String ROOM_ATLAS_SEPARATOR = "-";
    public static final String OCCUPANCY_SEPARATOR = "~";
    public static final String SI_CODE = "s";
    private static final String NO = "No";
    private static final String YES = "Yes";
    private static final String ONLY = "Only";
    private static final int STATUS_CONFIRMED = 0;
    private static final int STATUS_CANCELLED = 100;
    private static final int INTERNAL_STATUS_NEW = 200;
    private static final int INTERNAL_STATUS_TO_BE_UPDATED = 300;
    private static final int INTERNAL_STATUS_PRECONFIRMED = 500;
    private static final String SI = "Si";

    private SimpleTypes() {
    }

    @XmlType(name = "ChangeMode")
    @XmlEnum
    public enum ChangeMode {
        SIMULATION(YesNo.Y),
        UPDATE(YesNo.N);

        private YesNo internal;

        private ChangeMode(final YesNo internal) {
            this.internal = internal;
        }

        public YesNo getInternal() {
            return internal;
        }

        public String getBDDValue() {
            return internal.getBDDValue();
        }
    }

    @XmlType(name = "YesNo")
    @XmlEnum
    public enum YesNo {
        Y(SimpleTypes.YES, SiNo.S, "Y"),
        N(SimpleTypes.NO, SiNo.N, "N"),
        O(SimpleTypes.ONLY, SiNo.N, "O");
        private String label;
        private SiNo internal;
        private String bddValue;

        YesNo(final String label, final SiNo internal, final String bddValue) {
            this.label = label;
            this.internal = internal;
            this.bddValue = bddValue;
        }

        public String getLabel() {
            return label;
        }

        public SiNo getInternal() {
            return internal;
        }

        public String getBDDValue() {
            return bddValue;
        }

        public static YesNo getFromBoolean(final Boolean value) {
            if (value == null) {
                return null;
            } else if (Boolean.TRUE.equals(value)) {
                return YesNo.Y;
            } else {
                return YesNo.N;
            }
        }

        public static YesNo getSafeValue(final String value) {
            if (SimpleTypes.SI_CODE.equalsIgnoreCase(value)) {
                return YesNo.Y;
            } else {
                return YesNo.valueOf(value);
            }
        }

        public static boolean getBoolean(YesNo yesNo) {
            return YesNo.Y.equals(yesNo);
        }

        public static boolean getBoolean(Object value) {
            return "Y".equals(value) || "S".equals(value);
        }
    }
    public enum ShowDirectPayment {
        //liberate
        AT_HOTEL("S", "YES"),
        AT_WEB("N", "NO"),
        BOTH("A", "BOTH");
        private String aceLabel;
        private String genericLabel;
        private static Map<String, ShowDirectPayment> showDirectPaymentByAceValue = new HashMap<>();

        static {
            for (ShowDirectPayment showDirectPayment : ShowDirectPayment.values()) {
                showDirectPaymentByAceValue.put(showDirectPayment.getAceLabel(), showDirectPayment);
            }
        }

        ShowDirectPayment(final String aceLabel, final String genericLabel) {
            this.aceLabel = aceLabel;
            this.genericLabel = genericLabel;
        }

        public String getAceLabel() {
            return aceLabel;
        }

        public String getGenericLabel() {
            return genericLabel;
        }

        /**
         * Translates DirectPayments values from Ace to the ones used in Hotel-
         *
         * @param value
         * @return
         */
        public static ShowDirectPayment getDirectPaymentFromAceValue(final String value) {
            return showDirectPaymentByAceValue.get(value);
        }
    }
    public enum SiNo {
        S(SI, YesNo.Y),
        N(NO, YesNo.N);
        private String label;
        private YesNo internal;

        SiNo(final String label, final YesNo internal) {
            this.label = label;
            this.internal = internal;
        }

        public String getLabel() {
            return label;
        }

        public YesNo getInternal() {
            return internal;
        }

        public static SiNo getSafeValue(final String value) {
            if (SiNo.S.name().equalsIgnoreCase(value)) {
                return SiNo.S;
            } else {
                return SiNo.valueOf(value);
            }
        }

        public boolean toBoolean() {
            return SiNo.S.equals(this) ? true : false;
        }

        public static SiNo getFromBoolean(Boolean value) {
            if (Boolean.TRUE.equals(value)) {
                return SiNo.S;
            } else {
                return SiNo.N;
            }
        }
    }
    public enum HotelbedsCustomerType {
        /**
         * Used for adult.
         */
        AD("2", 30, "A", "A", "AD", "AD")
        /**
         * Used for children.
         */
        ,CH("1", 8, "C", "N", "NI", "CH");
        private final String paxType;
        private final int defaultAge;
        private final String paxId;
        private final String paxCode;
        private final String atlasCode;
        private final String englishType;

        HotelbedsCustomerType(final String paxType, final int defaultAge, final String paxId, final String paxCode, final String atlasCode,
            final String englishType) {
            this.paxType = paxType;
            this.defaultAge = defaultAge;
            this.paxId = paxId;
            this.paxCode = paxCode;
            this.atlasCode = atlasCode;
            this.englishType = englishType;
        }

        public String getPaxType() {
            return paxType;
        }

        public int getDefaultAge() {
            return defaultAge;
        }

        public String getPaxId() {
            return paxId;
        }

        public String getPaxCode() {
            return paxCode;
        }

        public String getAtlasCode() {
            return atlasCode;
        }

        public String getEnglishType() {
            return englishType;
        }

        public static HotelbedsCustomerType getCustomerType(final String customerType) {
            if (customerType != null && isCustomerTypeAdult(customerType)) {
                return HotelbedsCustomerType.AD;
            } else {
                return HotelbedsCustomerType.CH;
            }
        }

        private static boolean isCustomerTypeAdult(String customerType) {
            HashSet<String> adultCustomerValues = new HashSet<>();
            adultCustomerValues.add(HotelbedsCustomerType.AD.getPaxId());
            adultCustomerValues.add(HotelbedsCustomerType.AD.getAtlasCode());
            adultCustomerValues.add(HotelbedsCustomerType.AD.getPaxCode());
            adultCustomerValues.add(HotelbedsCustomerType.AD.getPaxType());

            return adultCustomerValues.contains(customerType);
        }

        public static HotelbedsCustomerType getCustomerTypeFromPaxId(final String paxId) {
            if (HotelbedsCustomerType.AD.getPaxId().equals(paxId)) {
                return HotelbedsCustomerType.AD;
            } else {
                return HotelbedsCustomerType.CH;
            }
        }
    }
    public enum HotelbedsTicketClass {
        T,
        E
    }
    public enum RateType {
        BOOKABLE,
        RECHECK
    }
    public enum CommissionType {
        LIBERATE_RATE("L"),
        NET_RATE("N"),
        COMISSIONABLE_RATE("O"),
        COMISSIONABLE_DISCOUNT_RATE("V");
        private final String type;

        private CommissionType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public static CommissionType getCommissionType(final String commissionType) {
            CommissionType result = null;
            if (CommissionType.LIBERATE_RATE.type.equals(commissionType)) {
                result = CommissionType.LIBERATE_RATE;
            } else if (CommissionType.NET_RATE.type.equals(commissionType)) {
                result = CommissionType.NET_RATE;
            } else if (CommissionType.COMISSIONABLE_RATE.type.equals(commissionType)) {
                result = CommissionType.COMISSIONABLE_RATE;
            } else if (CommissionType.COMISSIONABLE_DISCOUNT_RATE.type.equals(commissionType)) {
                result = CommissionType.COMISSIONABLE_DISCOUNT_RATE;
            }
            return result;
        }
    }
    public enum PaymentType {
        AT_HOTEL("P", "H"),
        AT_WEB("C", "W");
        private final String abbreviated;
        private final String rateKeyValue;

        private PaymentType(String abbreviated, String rateKeyValue) {
            this.abbreviated = abbreviated;
            this.rateKeyValue = rateKeyValue;
        }

        public String getAbbreviated() {
            return abbreviated;
        }

        public String getRateKeyValue() {
            return rateKeyValue;
        }

        public static PaymentType getPaymentType(final boolean directPayment) {
            PaymentType result;
            if (directPayment) {
                result = PaymentType.AT_HOTEL;
            } else {
                result = PaymentType.AT_WEB;
            }
            return result;
        }

        public static PaymentType getPaymentType(final String paymentType) {
            if (paymentType != null && (paymentType.equals(PaymentType.AT_HOTEL.abbreviated) || paymentType.equals(PaymentType.AT_HOTEL.name())
                || paymentType.equals(PaymentType.AT_HOTEL.rateKeyValue))) {
                return PaymentType.AT_HOTEL;
            } else {
                return PaymentType.AT_WEB;
            }
        }
    }
    public enum SupplementType {
        SUPPLEMENT("S"),
        DISCOUNT("D");
        private final String abbreviated;

        private SupplementType(String abbreviated) {
            this.abbreviated = abbreviated;
        }

        public String getAbbreviated() {
            return abbreviated;
        }

        public static SupplementType getSupplementType(final String supplementType) {
            SupplementType result = null;
            if (supplementType != null
                && (supplementType.equals(SupplementType.SUPPLEMENT.abbreviated) || supplementType.equals(SupplementType.SUPPLEMENT.name()))) {
                result = SupplementType.SUPPLEMENT;
            } else if (supplementType != null
                && (supplementType.equals(SupplementType.DISCOUNT.abbreviated) || supplementType.equals(SupplementType.DISCOUNT.name()))) {
                result = SupplementType.DISCOUNT;
            }
            return result;
        }
    }
    public enum TypeRequestAvail {
        TYPE_REQUEST_VALUATION_AVAIL,
        TYPE_REQUEST_AVAIL
    }
    public enum ProviderAvail {
        ACE,
        CARONTE
    }
    public enum CancellationFlags {
        CANCELLATION("C"),
        SIMULATION("S");
        private String flag;

        CancellationFlags(final String flag) {
            this.flag = flag;
        }

        public String getFlag() {
            return flag;
        }

        public static CancellationFlags getCancellationFlag(final String value) {
            if (value != null && value.equalsIgnoreCase(CancellationFlags.SIMULATION.name())) {
                return CancellationFlags.SIMULATION;
            } else {
                return CancellationFlags.CANCELLATION;
            }
        }
    }
    public enum BookingListFilterType {
        //E: busca por fechas de Entrada (Checking)
        CHECKIN("E"),
        //C: Busca por fechas de creación
        CREATION("C");
        private String type;

        BookingListFilterType(final String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public static BookingListFilterType getBookingListFilterType(final String type) {
            if (type != null && type.equalsIgnoreCase(BookingListFilterType.CREATION.name())) {
                return BookingListFilterType.CREATION;
            } else {
                //Por defecto filterType de bookingList vale "E" = "CHECKIN"
                return BookingListFilterType.CHECKIN;
            }
        }
    }
    public enum Accommodation {
        HOTEL("HOTEL"),
        APARTMENT("APART"),
        RURAL("RURAL"),
        HOSTEL("HOSTEL"),
        APTHOTEL("APTHOTEL"),
        CAMPING("CAMPING"),
        HISTORIC("HOTEL "),
        PENDING("PENDING"),
        RESORT("RESORT"),
        HOMES("HOMES");
        private String type;
        private static Map<String, Accommodation> accommodationsByType = new HashMap<>();

        static {
            for (Accommodation accommodation : Accommodation.values()) {
                accommodationsByType.put(accommodation.getType(), accommodation);
            }
        }

        Accommodation(final String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public static Accommodation getAccommodationsByType(final String type) {
            Accommodation result = accommodationsByType.get(type.toUpperCase());
            if (result == null) {
                result = Accommodation.HOMES;
            }
            return result;
        }
    }
    public enum HotelCodeType {
        HOTELBEDS,
        GIATA;
    }
    public enum ChannelType {
        B2B,
        B2C,
        META,
        NEWSLETTER;
    }
    public enum DeviceType {
        MOBILE,
        WEB,
        TABLET;
    }
    public enum ReviewsType {
        TRIPADVISOR("TRIPADVISOR"),
        HOTELBEDS("HOTELBEDS");
        private String requestType;

        ReviewsType(final String type) {
            requestType = type;
        }

        public String getRequestType() {
            return requestType;
        }

        public static ReviewsType getReviewsType(final String requestType) {
            ReviewsType result = null;
            if (requestType != null && (requestType.equalsIgnoreCase(ReviewsType.TRIPADVISOR.getRequestType()))) {
                result = ReviewsType.TRIPADVISOR;
            } else if (requestType != null && requestType.equalsIgnoreCase(ReviewsType.HOTELBEDS.getRequestType())) {
                result = ReviewsType.HOTELBEDS;
            }
            return result;
        }
    }
    public enum AvailabilitySorter {
        RATE("P"),
        PRIORITY("");
        private String cachedValue;

        AvailabilitySorter(String cachedValue) {
            this.cachedValue = cachedValue;
        }

        public String getCachedValue() {
            return cachedValue;
        }
    }
    public enum TaxType {
        TAX("T"),
        FEE("F");
        private String internalCode;

        TaxType(String internalCode) {
            this.internalCode = internalCode;
        }

        public String getInternalCode() {
            return internalCode;
        }

        public static TaxType getTaxType(String internalCode) {
            TaxType result = null;
            if (TAX.getInternalCode().equals(internalCode)) {
                result = TAX;
            } else if (FEE.getInternalCode().equals(internalCode)) {
                result = FEE;
            } else {
                log.debug("TaxType not found with this internalCode: " + internalCode);
            }
            return result;
        }
    }
    public enum HotelPackage {
        YES,
        NO,
        BOTH
    }

    public static enum ShoppingCartStatus {
        NEW(INTERNAL_STATUS_NEW),
        PRECONFIRMED(INTERNAL_STATUS_PRECONFIRMED),
        CONFIRMED(STATUS_CONFIRMED),
        TO_BE_UPDATED(INTERNAL_STATUS_TO_BE_UPDATED),
        CANCELLED(STATUS_CANCELLED);

        private final int code;

        ShoppingCartStatus(final int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        private static final Map<Integer, ShoppingCartStatus> statusByCode = new HashMap<>();

        public static final ShoppingCartStatus withCode(final int code) {
            return statusByCode.get(code);
        }

        static {
            for (ShoppingCartStatus shoppingCartStatus : ShoppingCartStatus.values()) {
                statusByCode.put(shoppingCartStatus.getCode(), shoppingCartStatus);
            }
        }
    }

}
