package com.example.madcamp_week1.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
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
import com.example.madcamp_week1.repository.model.Todo;
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
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TodoDao_Impl implements TodoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Todo> __insertionAdapterOfTodo;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Todo> __deletionAdapterOfTodo;

  private final EntityDeletionOrUpdateAdapter<Todo> __updateAdapterOfTodo;

  public TodoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTodo = new EntityInsertionAdapter<Todo>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Todo` (`todoId`,`contact_id_list`,`image_id_list`,`group_id`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Todo entity) {
        statement.bindLong(1, entity.getTodoId());
        final long _tmp = __converters.fromDate(entity.getTodoStartDate());
        statement.bindLong(2, _tmp);
        final long _tmp_1 = __converters.fromDate(entity.getTodoEndDate());
        statement.bindLong(3, _tmp_1);
        statement.bindLong(4, entity.getGroupId());
      }
    };
    this.__deletionAdapterOfTodo = new EntityDeletionOrUpdateAdapter<Todo>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `Todo` WHERE `todoId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Todo entity) {
        statement.bindLong(1, entity.getTodoId());
      }
    };
    this.__updateAdapterOfTodo = new EntityDeletionOrUpdateAdapter<Todo>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `Todo` SET `todoId` = ?,`contact_id_list` = ?,`image_id_list` = ?,`group_id` = ? WHERE `todoId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Todo entity) {
        statement.bindLong(1, entity.getTodoId());
        final long _tmp = __converters.fromDate(entity.getTodoStartDate());
        statement.bindLong(2, _tmp);
        final long _tmp_1 = __converters.fromDate(entity.getTodoEndDate());
        statement.bindLong(3, _tmp_1);
        statement.bindLong(4, entity.getGroupId());
        statement.bindLong(5, entity.getTodoId());
      }
    };
  }

  @Override
  public Object insertTodo(final Todo todo, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfTodo.insert(todo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTodo(final Todo todo, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTodo.handle(todo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTodo(final Todo todo, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTodo.handle(todo);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTodoByTodoId(final long todoId, final Continuation<? super Todo> $completion) {
    final String _sql = "SELECT * FROM Todo WHERE todoId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, todoId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Todo>() {
      @Override
      @NonNull
      public Todo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTodoId = CursorUtil.getColumnIndexOrThrow(_cursor, "todoId");
          final int _cursorIndexOfTodoStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_id_list");
          final int _cursorIndexOfTodoEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "image_id_list");
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
          final Todo _result;
          if (_cursor.moveToFirst()) {
            final long _tmpTodoId;
            _tmpTodoId = _cursor.getLong(_cursorIndexOfTodoId);
            final Date _tmpTodoStartDate;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfTodoStartDate);
            _tmpTodoStartDate = __converters.toDate(_tmp);
            final Date _tmpTodoEndDate;
            final long _tmp_1;
            _tmp_1 = _cursor.getLong(_cursorIndexOfTodoEndDate);
            _tmpTodoEndDate = __converters.toDate(_tmp_1);
            final long _tmpGroupId;
            _tmpGroupId = _cursor.getLong(_cursorIndexOfGroupId);
            _result = new Todo(_tmpTodoId,_tmpTodoStartDate,_tmpTodoEndDate,_tmpGroupId);
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
  public Object getAllTodo(final Continuation<? super List<Todo>> $completion) {
    final String _sql = "SELECT * FROM Todo";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Todo>>() {
      @Override
      @NonNull
      public List<Todo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTodoId = CursorUtil.getColumnIndexOrThrow(_cursor, "todoId");
          final int _cursorIndexOfTodoStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_id_list");
          final int _cursorIndexOfTodoEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "image_id_list");
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
          final List<Todo> _result = new ArrayList<Todo>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Todo _item;
            final long _tmpTodoId;
            _tmpTodoId = _cursor.getLong(_cursorIndexOfTodoId);
            final Date _tmpTodoStartDate;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfTodoStartDate);
            _tmpTodoStartDate = __converters.toDate(_tmp);
            final Date _tmpTodoEndDate;
            final long _tmp_1;
            _tmp_1 = _cursor.getLong(_cursorIndexOfTodoEndDate);
            _tmpTodoEndDate = __converters.toDate(_tmp_1);
            final long _tmpGroupId;
            _tmpGroupId = _cursor.getLong(_cursorIndexOfGroupId);
            _item = new Todo(_tmpTodoId,_tmpTodoStartDate,_tmpTodoEndDate,_tmpGroupId);
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
  public Object getTodoListByGroupId(final long groupId,
      final Continuation<? super List<Todo>> $completion) {
    final String _sql = "SELECT * FROM Todo WHERE group_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, groupId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Todo>>() {
      @Override
      @NonNull
      public List<Todo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTodoId = CursorUtil.getColumnIndexOrThrow(_cursor, "todoId");
          final int _cursorIndexOfTodoStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_id_list");
          final int _cursorIndexOfTodoEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "image_id_list");
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
          final List<Todo> _result = new ArrayList<Todo>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Todo _item;
            final long _tmpTodoId;
            _tmpTodoId = _cursor.getLong(_cursorIndexOfTodoId);
            final Date _tmpTodoStartDate;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfTodoStartDate);
            _tmpTodoStartDate = __converters.toDate(_tmp);
            final Date _tmpTodoEndDate;
            final long _tmp_1;
            _tmp_1 = _cursor.getLong(_cursorIndexOfTodoEndDate);
            _tmpTodoEndDate = __converters.toDate(_tmp_1);
            final long _tmpGroupId;
            _tmpGroupId = _cursor.getLong(_cursorIndexOfGroupId);
            _item = new Todo(_tmpTodoId,_tmpTodoStartDate,_tmpTodoEndDate,_tmpGroupId);
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
  public Object getTodoListByTodoIdList(final List<Long> todoIdList,
      final Continuation<? super List<Todo>> $completion) {
    final StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM Todo WHERE todoId IN (");
    final int _inputSize = todoIdList.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Long _item : todoIdList) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex++;
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Todo>>() {
      @Override
      @NonNull
      public List<Todo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTodoId = CursorUtil.getColumnIndexOrThrow(_cursor, "todoId");
          final int _cursorIndexOfTodoStartDate = CursorUtil.getColumnIndexOrThrow(_cursor, "contact_id_list");
          final int _cursorIndexOfTodoEndDate = CursorUtil.getColumnIndexOrThrow(_cursor, "image_id_list");
          final int _cursorIndexOfGroupId = CursorUtil.getColumnIndexOrThrow(_cursor, "group_id");
          final List<Todo> _result = new ArrayList<Todo>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Todo _item_1;
            final long _tmpTodoId;
            _tmpTodoId = _cursor.getLong(_cursorIndexOfTodoId);
            final Date _tmpTodoStartDate;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfTodoStartDate);
            _tmpTodoStartDate = __converters.toDate(_tmp);
            final Date _tmpTodoEndDate;
            final long _tmp_1;
            _tmp_1 = _cursor.getLong(_cursorIndexOfTodoEndDate);
            _tmpTodoEndDate = __converters.toDate(_tmp_1);
            final long _tmpGroupId;
            _tmpGroupId = _cursor.getLong(_cursorIndexOfGroupId);
            _item_1 = new Todo(_tmpTodoId,_tmpTodoStartDate,_tmpTodoEndDate,_tmpGroupId);
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
