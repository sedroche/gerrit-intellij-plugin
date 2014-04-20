// Copyright (C) 2013 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.gerrit.extensions.api.changes;

import com.google.gerrit.extensions.restapi.RestApiException;

import java.util.List;
import java.util.Map;

public interface RevisionApi {
  void delete() throws RestApiException;
  void review(ReviewInput in) throws RestApiException;

  /** {@code submit} with {@link SubmitInput#waitForMerge} set to true. */
  void submit() throws RestApiException;
  void submit(SubmitInput in) throws RestApiException;
  void publish() throws RestApiException;
  ChangeApi cherryPick(CherryPickInput in) throws RestApiException;
  ChangeApi rebase() throws RestApiException;
  boolean canRebase();
  void changeReviewed(String filePath, boolean reviewed) throws RestApiException; // added uwolfer
  Map<String, List<ReviewInput.Comment>> getComments() throws RestApiException; // added uwolfer
}
