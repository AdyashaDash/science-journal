/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.android.apps.forscience.whistlepunk.sensorapi;

import com.google.android.apps.forscience.javalib.MaybeConsumer;
import com.google.android.apps.forscience.javalib.Success;
import com.google.common.base.Preconditions;

public class DelegatingSensorRecorder implements SensorRecorder {
    private final SensorRecorder mDelegate;

    public DelegatingSensorRecorder(SensorRecorder delegate) {
        mDelegate = Preconditions.checkNotNull(delegate);
    }

    public void startObserving() {
        mDelegate.startObserving();
    }

    public void startRecording(String runId) {
        mDelegate.startRecording(runId);
    }

    public void applyOptions(ReadableSensorOptions settings) {
        mDelegate.applyOptions(settings);
    }

    public void stopRecording(MaybeConsumer<Success> onSuccess) {
        mDelegate.stopRecording(onSuccess);
    }

    public void stopObserving() {
        mDelegate.stopObserving();
    }

    @Override
    public boolean hasRecordedData() {
        return mDelegate.hasRecordedData();
    }
}
