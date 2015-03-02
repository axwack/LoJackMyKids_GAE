package com.principalmvl.lojackmykids.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2015-03-02 11:27:28")
/** */
public final class ContactMeta extends org.slim3.datastore.ModelMeta<com.principalmvl.lojackmykids.model.Contact> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.principalmvl.lojackmykids.model.Contact, java.util.Date> createDate = new org.slim3.datastore.CoreAttributeMeta<com.principalmvl.lojackmykids.model.Contact, java.util.Date>(this, "createDate", "createDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.principalmvl.lojackmykids.model.Contact> email = new org.slim3.datastore.StringAttributeMeta<com.principalmvl.lojackmykids.model.Contact>(this, "email", "email");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.principalmvl.lojackmykids.model.Contact, com.google.appengine.api.datastore.Key> key = new org.slim3.datastore.CoreAttributeMeta<com.principalmvl.lojackmykids.model.Contact, com.google.appengine.api.datastore.Key>(this, "__key__", "key", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<com.principalmvl.lojackmykids.model.Contact, java.util.Date> lastUpdateDate = new org.slim3.datastore.CoreAttributeMeta<com.principalmvl.lojackmykids.model.Contact, java.util.Date>(this, "lastUpdateDate", "lastUpdateDate", java.util.Date.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<com.principalmvl.lojackmykids.model.Contact> regId = new org.slim3.datastore.StringAttributeMeta<com.principalmvl.lojackmykids.model.Contact>(this, "regId", "regId");

    private static final ContactMeta slim3_singleton = new ContactMeta();

    /**
     * @return the singleton
     */
    public static ContactMeta get() {
       return slim3_singleton;
    }

    /** */
    public ContactMeta() {
        super("Contact", com.principalmvl.lojackmykids.model.Contact.class);
    }

    @Override
    public com.principalmvl.lojackmykids.model.Contact entityToModel(com.google.appengine.api.datastore.Entity entity) {
        com.principalmvl.lojackmykids.model.Contact model = new com.principalmvl.lojackmykids.model.Contact();
        model.setCreateDate((java.util.Date) entity.getProperty("createDate"));
        model.setEmail((java.lang.String) entity.getProperty("email"));
        model.setKey(entity.getKey());
        model.setLastUpdateDate((java.util.Date) entity.getProperty("lastUpdateDate"));
        model.setRegId((java.lang.String) entity.getProperty("regId"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        com.principalmvl.lojackmykids.model.Contact m = (com.principalmvl.lojackmykids.model.Contact) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getKey() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getKey());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("createDate", m.getCreateDate());
        entity.setProperty("email", m.getEmail());
        entity.setProperty("lastUpdateDate", m.getLastUpdateDate());
        entity.setProperty("regId", m.getRegId());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        com.principalmvl.lojackmykids.model.Contact m = (com.principalmvl.lojackmykids.model.Contact) model;
        return m.getKey();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        com.principalmvl.lojackmykids.model.Contact m = (com.principalmvl.lojackmykids.model.Contact) model;
        m.setKey(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(com.principalmvl.lojackmykids.model.Contact) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        com.principalmvl.lojackmykids.model.Contact m = (com.principalmvl.lojackmykids.model.Contact) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCreateDate() != null){
            writer.setNextPropertyName("createDate");
            encoder0.encode(writer, m.getCreateDate());
        }
        if(m.getEmail() != null){
            writer.setNextPropertyName("email");
            encoder0.encode(writer, m.getEmail());
        }
        if(m.getKey() != null){
            writer.setNextPropertyName("key");
            encoder0.encode(writer, m.getKey());
        }
        if(m.getLastUpdateDate() != null){
            writer.setNextPropertyName("lastUpdateDate");
            encoder0.encode(writer, m.getLastUpdateDate());
        }
        if(m.getRegId() != null){
            writer.setNextPropertyName("regId");
            encoder0.encode(writer, m.getRegId());
        }
        writer.endObject();
    }

    @Override
    protected com.principalmvl.lojackmykids.model.Contact jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        com.principalmvl.lojackmykids.model.Contact m = new com.principalmvl.lojackmykids.model.Contact();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("createDate");
        m.setCreateDate(decoder0.decode(reader, m.getCreateDate()));
        reader = rootReader.newObjectReader("email");
        m.setEmail(decoder0.decode(reader, m.getEmail()));
        reader = rootReader.newObjectReader("key");
        m.setKey(decoder0.decode(reader, m.getKey()));
        reader = rootReader.newObjectReader("lastUpdateDate");
        m.setLastUpdateDate(decoder0.decode(reader, m.getLastUpdateDate()));
        reader = rootReader.newObjectReader("regId");
        m.setRegId(decoder0.decode(reader, m.getRegId()));
        return m;
    }
}