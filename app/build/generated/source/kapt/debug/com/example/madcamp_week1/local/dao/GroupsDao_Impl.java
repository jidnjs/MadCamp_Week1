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
import com.example.madcamp_week1.repository.model.Group;
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
public final class GroupsDao_Impl implements GroupsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Group> __insertionAdapterOfGroup;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Group> __deletionAdapterOfGroup;

  private final EntityDeletionOrUpdateAdapter<Group> __updateAdapterOfGroup;

  public GroupsDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfGroup = new EntityInsertionAdapter<Group>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Group` (`groupId`,`group_name`,`contact_id_list`,`image_id_list`,`todo_id_list`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Group entity) {
        statement.bindLong(1, entity.getGroupId());
        if (entity.getGroupName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getGroupName());
        }
        final String _tmp = __converters.fromList(entity.getContactIdList());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        final String _tmp_1 = __converters.fromList(entity.getImageIdList());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp_1);
        }
        final String _tmp_2 = __converters.fromList(entity.getTodoIdList());
        if (_tmp_2 == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmp_2);
        }
      }
    };
    this.__deletionAdapterOfGroup = new EntityDeletionOrUpdateAdapter<Group>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Group` WHERE `groupId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Group entity) {
        statement.bindLong(1, entity.getGroupId());
      }
    };
    this.__updateAdapterOfGroup = new EntityDeletionOrUpdateAdapter<Group>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Group` SET `groupId` = ?,`group_name` = ?,`contact_id_list` = ?,`image_id_list` = ?,`todo_id_list` = ? WHERE `groupId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Group entity) {
        statement.bindLong(1, entity.getGroupId());
        if (entity.getGroupName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getGroupName());
        }
        final String _tmp = __converters.fromList(entity.getContactIdList());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        final String _tmp_1 = __converters.fromList(entity.getImageIdList());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp_1);
        }
        final String _tmp_2 = __converters.fromList(entity.getTodoIdList());
        if (_tmp_2 == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmp_2);
        }
        statement.bindLong(6, entity.getGroupId());
      }
    };
  }

  @Override
  public Object insertGroup(final Group group, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfGroup.insert(group);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteGroup(final Group group, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfGroup.handle(group);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateGroup(final Group group, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfGroup.handle(group);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getGroupByGroupId(final long groupId,
      final Continuation<? super Group> $completion) {
    final String _sql = "SELECT * FROM `Group` WHERE groupId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, groupId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Group>() {
      @Override
      @Nullable
      public Group call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "groupId");
          final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "group_name");
          final int _cursorIndexOfContactIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_id_list");
          final int _cursorIndexOfImageIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "image_id_list");
          final int _cursorIndexOfTodoIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "todo_id_list");
          final Group _result;
          if (_cursor.moveToFirst()) {
            final long _tmpGroupId;
            _tmpGroupId = _cursor.getLong(_cursorIndexOfGroupId);
            final String _tmpGroupName;
            if (_cursor.isNull(_cursorIndexOfGroupName)) {
              _tmpGroupName = null;
            } else {
              _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
            }
            final List<Long> _tmpContactIdList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfContactIdList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfContactIdList);
            }
            _tmpContactIdList = __converters.toList(_tmp);
            final List<Long> _tmpImageIdList;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfImageIdList)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfImageIdList);
            }
            _tmpImageIdList = __converters.toList(_tmp_1);
            final List<Long> _tmpTodoIdList;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfTodoIdList)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfTodoIdList);
            }
            _tmpTodoIdList = __converters.toList(_tmp_2);
            _result = new Group(_tmpGroupId,_tmpGroupName,_tmpContactIdList,_tmpImageIdList,_tmpTodoIdList);
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
  public Object getAllGroups(final Continuation<? super List<Group>> $completion) {
    final String _sql = "SELECT * FROM `Group`";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Group>>() {
      @Override
      @NonNull
      public List<Group> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "groupId");
          final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "group_name");
          final int _cursorIndexOfContactIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_id_list");
          final int _cursorIndexOfImageIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "image_id_list");
          final int _cursorIndexOfTodoIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "todo_id_list");
          final List<Group> _result = new ArrayList<Group>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Group _item;
            final long _tmpGroupId;
            _tmpGroupId = _cursor.getLong(_cursorIndexOfGroupId);
            final String _tmpGroupName;
            if (_cursor.isNull(_cursorIndexOfGroupName)) {
              _tmpGroupName = null;
            } else {
              _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
            }
            final List<Long> _tmpContactIdList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfContactIdList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfContactIdList);
            }
            _tmpContactIdList = __converters.toList(_tmp);
            final List<Long> _tmpImageIdList;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfImageIdList)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfImageIdList);
            }
            _tmpImageIdList = __converters.toList(_tmp_1);
            final List<Long> _tmpTodoIdList;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfTodoIdList)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfTodoIdList);
            }
            _tmpTodoIdList = __converters.toList(_tmp_2);
            _item = new Group(_tmpGroupId,_tmpGroupName,_tmpContactIdList,_tmpImageIdList,_tmpTodoIdList);
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
  public Object getGroupListByGroupIdList(final List<Long> groupIdList,
      final Continuation<? super List<Group>> $completion) {
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM `Group` WHERE groupId IN (");
    final int _inputSize = groupIdList.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Long _item : groupIdList) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex++;
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Group>>() {
      @Override
      @NonNull
      public List<Group> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "groupId");
          final int _cursorIndexOfGroupName = CursorUtil.getColumnIndexOrThrow(_cursor, "group_name");
          final int _cursorIndexOfContactIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_id_list");
          final int _cursorIndexOfImageIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "image_id_list");
          final int _cursorIndexOfTodoIdList = CursorUtil.getColumnIndexOrThrow(_cursor, "todo_id_list");
          final List<Group> _result = new ArrayList<Group>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Group _item_1;
            final long _tmpGroupId;
            _tmpGroupId = _cursor.getLong(_cursorIndexOfGroupId);
            final String _tmpGroupName;
            if (_cursor.isNull(_cursorIndexOfGroupName)) {
              _tmpGroupName = null;
            } else {
              _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
            }
            final List<Long> _tmpContactIdList;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfContactIdList)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfContactIdList);
            }
            _tmpContactIdList = __converters.toList(_tmp);
            final List<Long> _tmpImageIdList;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfImageIdList)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfImageIdList);
            }
            _tmpImageIdList = __converters.toList(_tmp_1);
            final List<Long> _tmpTodoIdList;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfTodoIdList)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfTodoIdList);
            }
            _tmpTodoIdList = __converters.toList(_tmp_2);
            _item_1 = new Group(_tmpGroupId,_tmpGroupName,_tmpContactIdList,_tmpImageIdList,_tmpTodoIdList);
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
