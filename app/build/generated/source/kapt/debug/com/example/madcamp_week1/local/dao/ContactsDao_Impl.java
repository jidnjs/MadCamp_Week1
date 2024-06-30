package com.example.madcamp_week1.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.madcamp_week1.local.database.Converters;
import com.example.madcamp_week1.repository.model.Contact;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ContactsDao_Impl implements ContactsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Contact> __insertionAdapterOfContact;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Contact> __deletionAdapterOfContact;

  private final EntityDeletionOrUpdateAdapter<Contact> __updateAdapterOfContact;

  public ContactsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfContact = new EntityInsertionAdapter<Contact>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Contact` (`contactId`,`contact_name`,`contact_phone_number`,`contact_email`,`contact_memo`,`group_id_list`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Contact entity) {
        statement.bindLong(1, entity.getContactId());
        if (entity.getContactName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getContactName());
        }
        statement.bindLong(3, entity.getContactPhoneNumber());
        if (entity.getContactEmail() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getContactEmail());
        }
        if (entity.getContactMemo() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getContactMemo());
        }
        final String _tmp = __converters.fromList(entity.getGroupIdList());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp);
        }
      }
    };
    this.__deletionAdapterOfContact = new EntityDeletionOrUpdateAdapter<Contact>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Contact` WHERE `contactId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Contact entity) {
        statement.bindLong(1, entity.getContactId());
      }
    };
    this.__updateAdapterOfContact = new EntityDeletionOrUpdateAdapter<Contact>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Contact` SET `contactId` = ?,`contact_name` = ?,`contact_phone_number` = ?,`contact_email` = ?,`contact_memo` = ?,`group_id_list` = ? WHERE `contactId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Contact entity) {
        statement.bindLong(1, entity.getContactId());
        if (entity.getContactName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getContactName());
        }
        statement.bindLong(3, entity.getContactPhoneNumber());
        if (entity.getContactEmail() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getContactEmail());
        }
        if (entity.getContactMemo() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getContactMemo());
        }
        final String _tmp = __converters.fromList(entity.getGroupIdList());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, _tmp);
        }
        statement.bindLong(7, entity.getContactId());
      }
    };
  }

  @Override
  public Object insertContact(final Contact contact, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfContact.insert(contact);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteContact(final Contact contact, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfContact.handle(contact);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateContact(final Contact contact, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfContact.handle(contact);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getContactByContactId(final long contactId,
      final Continuation<? super Contact> $completion) {
    final String _sql = "SELECT * FROM Contact WHERE contactId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, contactId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Contact>() {
      @Override
      @Nullable
      public Contact call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfContactPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_phone_number");
          final int _cursorIndexOfContactEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_email");
          final int _cursorIndexOfContactMemo = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_memo");
          final int _cursorIndexOfGroupIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id_list");
          final Contact _result;
          if (_cursor.moveToFirst()) {
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final String _tmpContactName;
            if (_cursor.isNull(_cursorIndexOfContactName)) {
              _tmpContactName = null;
            } else {
              _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            }
            final int _tmpContactPhoneNumber;
            _tmpContactPhoneNumber = _cursor.getInt(_cursorIndexOfContactPhoneNumber);
            final String _tmpContactEmail;
            if (_cursor.isNull(_cursorIndexOfContactEmail)) {
              _tmpContactEmail = null;
            } else {
              _tmpContactEmail = _cursor.getString(_cursorIndexOfContactEmail);
            }
            final String _tmpContactMemo;
            if (_cursor.isNull(_cursorIndexOfContactMemo)) {
              _tmpContactMemo = null;
            } else {
              _tmpContactMemo = _cursor.getString(_cursorIndexOfContactMemo);
            }
            final List<Long> _tmpGroupIdList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGroupIdList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGroupIdList);
            }
            _tmpGroupIdList = __converters.toList(_tmp);
            _result = new Contact(_tmpContactId,_tmpContactName,_tmpContactPhoneNumber,_tmpContactEmail,_tmpContactMemo,_tmpGroupIdList);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getAllContacts(final Continuation<? super List<Contact>> $completion) {
    final String _sql = "SELECT * FROM Contact";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Contact>>() {
      @Override
      @NonNull
      public List<Contact> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfContactPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_phone_number");
          final int _cursorIndexOfContactEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_email");
          final int _cursorIndexOfContactMemo = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_memo");
          final int _cursorIndexOfGroupIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id_list");
          final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Contact _item;
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final String _tmpContactName;
            if (_cursor.isNull(_cursorIndexOfContactName)) {
              _tmpContactName = null;
            } else {
              _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            }
            final int _tmpContactPhoneNumber;
            _tmpContactPhoneNumber = _cursor.getInt(_cursorIndexOfContactPhoneNumber);
            final String _tmpContactEmail;
            if (_cursor.isNull(_cursorIndexOfContactEmail)) {
              _tmpContactEmail = null;
            } else {
              _tmpContactEmail = _cursor.getString(_cursorIndexOfContactEmail);
            }
            final String _tmpContactMemo;
            if (_cursor.isNull(_cursorIndexOfContactMemo)) {
              _tmpContactMemo = null;
            } else {
              _tmpContactMemo = _cursor.getString(_cursorIndexOfContactMemo);
            }
            final List<Long> _tmpGroupIdList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGroupIdList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGroupIdList);
            }
            _tmpGroupIdList = __converters.toList(_tmp);
            _item = new Contact(_tmpContactId,_tmpContactName,_tmpContactPhoneNumber,_tmpContactEmail,_tmpContactMemo,_tmpGroupIdList);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getContactListByGroupId(final long groupId,
      final Continuation<? super List<Contact>> $completion) {
    final String _sql = "SELECT * FROM Contact WHERE group_id_list LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, groupId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Contact>>() {
      @Override
      @NonNull
      public List<Contact> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfContactPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_phone_number");
          final int _cursorIndexOfContactEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_email");
          final int _cursorIndexOfContactMemo = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_memo");
          final int _cursorIndexOfGroupIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id_list");
          final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Contact _item;
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final String _tmpContactName;
            if (_cursor.isNull(_cursorIndexOfContactName)) {
              _tmpContactName = null;
            } else {
              _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            }
            final int _tmpContactPhoneNumber;
            _tmpContactPhoneNumber = _cursor.getInt(_cursorIndexOfContactPhoneNumber);
            final String _tmpContactEmail;
            if (_cursor.isNull(_cursorIndexOfContactEmail)) {
              _tmpContactEmail = null;
            } else {
              _tmpContactEmail = _cursor.getString(_cursorIndexOfContactEmail);
            }
            final String _tmpContactMemo;
            if (_cursor.isNull(_cursorIndexOfContactMemo)) {
              _tmpContactMemo = null;
            } else {
              _tmpContactMemo = _cursor.getString(_cursorIndexOfContactMemo);
            }
            final List<Long> _tmpGroupIdList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGroupIdList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGroupIdList);
            }
            _tmpGroupIdList = __converters.toList(_tmp);
            _item = new Contact(_tmpContactId,_tmpContactName,_tmpContactPhoneNumber,_tmpContactEmail,_tmpContactMemo,_tmpGroupIdList);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getContactListByContactIdList(final List<Long> contactIdList,
      final Continuation<? super List<Contact>> $completion) {
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Contact WHERE contactId IN (");
    final int _inputSize = contactIdList.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Long _item : contactIdList) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex++;
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Contact>>() {
      @Override
      @NonNull
      public List<Contact> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactName = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_name");
          final int _cursorIndexOfContactPhoneNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_phone_number");
          final int _cursorIndexOfContactEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_email");
          final int _cursorIndexOfContactMemo = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_memo");
          final int _cursorIndexOfGroupIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id_list");
          final List<Contact> _result = new ArrayList<Contact>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Contact _item_1;
            final long _tmpContactId;
            _tmpContactId = _cursor.getLong(_cursorIndexOfContactId);
            final String _tmpContactName;
            if (_cursor.isNull(_cursorIndexOfContactName)) {
              _tmpContactName = null;
            } else {
              _tmpContactName = _cursor.getString(_cursorIndexOfContactName);
            }
            final int _tmpContactPhoneNumber;
            _tmpContactPhoneNumber = _cursor.getInt(_cursorIndexOfContactPhoneNumber);
            final String _tmpContactEmail;
            if (_cursor.isNull(_cursorIndexOfContactEmail)) {
              _tmpContactEmail = null;
            } else {
              _tmpContactEmail = _cursor.getString(_cursorIndexOfContactEmail);
            }
            final String _tmpContactMemo;
            if (_cursor.isNull(_cursorIndexOfContactMemo)) {
              _tmpContactMemo = null;
            } else {
              _tmpContactMemo = _cursor.getString(_cursorIndexOfContactMemo);
            }
            final List<Long> _tmpGroupIdList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfGroupIdList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfGroupIdList);
            }
            _tmpGroupIdList = __converters.toList(_tmp);
            _item_1 = new Contact(_tmpContactId,_tmpContactName,_tmpContactPhoneNumber,_tmpContactEmail,_tmpContactMemo,_tmpGroupIdList);
            _result.add(_item_1);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
