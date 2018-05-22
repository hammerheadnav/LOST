package com.mapzen.android.lost.internal;

import com.mapzen.android.lost.api.LocationCallback;
import com.mapzen.android.lost.api.LocationListener;
import com.mapzen.android.lost.api.LostApiClient;

import android.app.PendingIntent;
import android.os.Looper;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Wraps an instance of {@link LostApiClient} along with its registered {@link LocationListener},
 * {@link PendingIntent}, or {@link LocationCallback} objects to be notified with location updates.
 */
class LostClientWrapper {
  private final LostApiClient client;

  private Set<LocationListener> locationListeners = new ConcurrentHashSet<>();
  private Set<PendingIntent> pendingIntents = new ConcurrentHashSet<>();
  private Set<LocationCallback> locationCallbacks = new ConcurrentHashSet<>();
  private Map<LocationCallback, Looper> looperMap = new ConcurrentHashMap<>();

  LostClientWrapper(LostApiClient client) {
    this.client = client;
  }

  public LostApiClient client() {
    return client;
  }

  Set<LocationListener> locationListeners() {
    return locationListeners;
  }

  Set<PendingIntent> pendingIntents() {
    return pendingIntents;
  }

  Set<LocationCallback> locationCallbacks() {
    return locationCallbacks;
  }

  Map<LocationCallback, Looper> looperMap() {
    return looperMap;
  }
}
