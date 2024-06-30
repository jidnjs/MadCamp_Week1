package com.example.madcamp_week1.local.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.example.madcamp_week1.local.dao.ContactsDao;
import com.example.madcamp_week1.local.dao.ContactsDao_Impl;
import com.example.madcamp_week1.local.dao.GroupsDao;
import com.example.madcamp_week1.local.dao.GroupsDao_Impl;
import com.example.madcamp_week1.local.dao.TodoDao;
import com.example.madcamp_week1.local.dao.TodoDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ContactsDao _contactsDao;

  private volatile GroupsDao _groupsDao;

  private volatile TodoDao _todoDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `Contact` (`contactId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `contact_name` TEXT NOT NULL, `contact_phone_number` INTEGER NOT NULL, `contact_email` TEXT NOT NULL, `contact_memo` TEXT NOT NULL, `group_id_list` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Group` (`groupId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `group_name` TEXT NOT NULL, `contact_id_list` TEXT NOT NULL, `image_id_list` TEXT NOT NULL, `todo_id_list` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `Todo` (`todoId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `contact_id_list` INTEGER NOT NULL, `image_id_list` INTEGER NOT NULL, `group_id` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9c4388e6cbac9c87f48925c8dba676e6')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `Contact`");
        db.execSQL("DROP TABLE IF EXISTS `Group`");
        db.execSQL("DROP TABLE IF EXISTS `Todo`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsContact = new HashMap<String, TableInfo.Column>(6);
        _columnsContact.put("contactId", new TableInfo.Column("contactId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("contact_name", new TableInfo.Column("contact_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("contact_phone_number", new TableInfo.Column("contact_phone_number", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("contact_email", new TableInfo.Column("contact_email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("contact_memo", new TableInfo.Column("contact_memo", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsContact.put("group_id_list", new TableInfo.Column("group_id_list", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysContact = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesContact = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoContact = new TableInfo("Contact", _columnsContact, _foreignKeysContact, _indicesContact);
        final TableInfo _existingContact = TableInfo.read(db, "Contact");
        if (!_infoContact.equals(_existingContact)) {
          return new RoomOpenHelper.ValidationResult(false, "Contact(com.example.madcamp_week1.repository.model.Contact).\n"
                  + " Expected:\n" + _infoContact + "\n"
                  + " Found:\n" + _existingContact);
        }
        final HashMap<String, TableInfo.Column> _columnsGroup = new HashMap<String, TableInfo.Column>(5);
        _columnsGroup.put("groupId", new TableInfo.Column("groupId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("group_name", new TableInfo.Column("group_name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("contact_id_list", new TableInfo.Column("contact_id_list", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("image_id_list", new TableInfo.Column("image_id_list", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGroup.put("todo_id_list", new TableInfo.Column("todo_id_list", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGroup = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGroup = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGroup = new TableInfo("Group", _columnsGroup, _foreignKeysGroup, _indicesGroup);
        final TableInfo _existingGroup = TableInfo.read(db, "Group");
        if (!_infoGroup.equals(_existingGroup)) {
          return new RoomOpenHelper.ValidationResult(false, "Group(com.example.madcamp_week1.repository.model.Group).\n"
                  + " Expected:\n" + _infoGroup + "\n"
                  + " Found:\n" + _existingGroup);
        }
        final HashMap<String, TableInfo.Column> _columnsTodo = new HashMap<String, TableInfo.Column>(4);
        _columnsTodo.put("todoId", new TableInfo.Column("todoId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTodo.put("contact_id_list", new TableInfo.Column("contact_id_list", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTodo.put("image_id_list", new TableInfo.Column("image_id_list", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTodo.put("group_id", new TableInfo.Column("group_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTodo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTodo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTodo = new TableInfo("Todo", _columnsTodo, _foreignKeysTodo, _indicesTodo);
        final TableInfo _existingTodo = TableInfo.read(db, "Todo");
        if (!_infoTodo.equals(_existingTodo)) {
          return new RoomOpenHelper.ValidationResult(false, "Todo(com.example.madcamp_week1.repository.model.Todo).\n"
                  + " Expected:\n" + _infoTodo + "\n"
                  + " Found:\n" + _existingTodo);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "9c4388e6cbac9c87f48925c8dba676e6", "8e092f26ff9b5fdd32e6ada3220e8c6d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Contact","Group","Todo");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Contact`");
      _db.execSQL("DELETE FROM `Group`");
      _db.execSQL("DELETE FROM `Todo`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ContactsDao.class, ContactsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(GroupsDao.class, GroupsDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TodoDao.class, TodoDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ContactsDao contactsDao() {
    if (_contactsDao != null) {
      return _contactsDao;
    } else {
      synchronized(this) {
        if(_contactsDao == null) {
          _contactsDao = new ContactsDao_Impl(this);
        }
        return _contactsDao;
      }
    }
  }

  @Override
  public GroupsDao groupsDao() {
    if (_groupsDao != null) {
      return _groupsDao;
    } else {
      synchronized(this) {
        if(_groupsDao == null) {
          _groupsDao = new GroupsDao_Impl(this);
        }
        return _groupsDao;
      }
    }
  }

  @Override
  public TodoDao todoDao() {
    if (_todoDao != null) {
      return _todoDao;
    } else {
      synchronized(this) {
        if(_todoDao == null) {
          _todoDao = new TodoDao_Impl(this);
        }
        return _todoDao;
      }
    }
  }
}
