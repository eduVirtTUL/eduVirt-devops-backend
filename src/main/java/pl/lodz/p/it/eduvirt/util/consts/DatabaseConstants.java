package pl.lodz.p.it.eduvirt.util.consts;

public class DatabaseConstants {

    // General

    // AbstractEntity

    public static final String PK = "id";
    public static final String VERSION = "version";

    // public.i72_metric

    public static final String METRIC_TABLE = "i72_metric";

    public static final String METRIC_NAME = "name";

    // HistoricData

    public static final String CREATED_BY = "created_by";
    public static final String UPDATED_BY = "updated_by";
    public static final String CREATED_AT = "_created_at";
    public static final String UPDATED_AT = "_updated_at";

    // Reservation module

    // public.i72_reservation

    public static final String RESERVATION_TABLE = "i72_reservation";

    public static final String RESERVATION_RESOURCE_GROUP_ID = "rg_id";
    public static final String RESERVATION_TEAM_ID = "team_id";
    public static final String RESERVATION_START = "reservation_start";
    public static final String RESERVATION_END = "reservation_end";
    public static final String RESERVATION_AUTOMATIC_STARTUP = "automatic_startup";

    // public.i72_reservation_audit_log

    public static final String RESERVATION_AUDIT_LOG_TABLE = "i72_reservation_audit_log";

    public static final String RESERVATION_AUDIT_LOG_EVENT_ID = "event_id";

    public static final String RESERVATION_AUDIT_LOG_RESERVATION_ID = "reservation_id";
    public static final String RESERVATION_AUDIT_LOG_RESERVATION_ID_FK = "reservation_audit_log_reservation_id_fk";
    public static final String RESERVATION_AUDIT_LOG_RESERVATION_ID_IDX = "reservation_audit_log_reservation_id_idx";

    public static final String RESERVATION_AUDIT_LOG_RESERVATION_ID_EVENT_ID_UNIQUE = "reservation_id_event_id_unique";

    // public.i72_metric_cluster

    public static final String CLUSTER_METRIC_TABLE = "i72_metric_cluster";

    public static final String CLUSTER_METRIC_VALUE = "metric_value";

    public static final String CLUSTER_METRIC_CLUSTER_ID = "cluster_id";

    public static final String CLUSTER_METRIC_METRIC_ID = "metric_id";
    public static final String CLUSTER_METRIC_METRIC_ID_FK = "cluster_metric_metric_id_fk";
    public static final String CLUSTER_METRIC_METRIC_ID_IDX = "cluster_metric_metric_id_idx";

    public static final String CLUSTER_METRIC_CLUSTER_ID_METRIC_ID_UNIQUE = "cluster_metric_cluster_id_unique";

    // public.i72_cluster_network

    public static final String CLUSTER_NETWORK_TABLE = "i72_cluster_network";

    public static final String CLUSTER_NETWORK_CLUSTER_ID = "cluster_id";
    public static final String CLUSTER_NETWORK_NETWORK_ID = "network_id";
}
