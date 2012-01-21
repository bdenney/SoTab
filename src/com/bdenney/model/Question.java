package com.bdenney.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Defines a question in StackOverflow.
 * @author Brandon
 */
public class Question implements JsonSerializable {	
	// Tags associated with the question.
	private final ArrayList<Tag> mTags = new ArrayList<Tag>();
	
	// The number of answers the question has.
	private long mAnswerCount;
	
	// The number of times the question has been added as a 'favorite'.
	private long mFavoriteCount;
	
	// The time line URL of the question.
	private String mTimelineUrl;
	
	// The comments URL of the question.
	private String mCommentsUrl;
	
	// The answers URL of the question.
	private String mAnswersUrl;
	
	// The ID of the question.
	private long mId;
	
	// A summary of the user who asked the question.
	private UserSummary mOwnerInfo;
	
	// When the question was created.
	private long mCreationDate;
	
	// The last time the question had activity on it.
	private long mLastActivityDate;
	
	// The number of up votes the question has received.
	private long mUpVoteCount;
	
	// The number of down votes the question has received.
	private long mDownVoteCount;
	
	// The number of times the question has been viewed.
	private long mViews;
	
	// TODO: Figure out what this means.
	private long mScore;
	
	// Flag indicating whether or not the question is community owned.
	private boolean mCommunityOwned;
	
	// The title of the question.
	private String mTitle;

	/*
	 *
"questions": [
  {
   "tags": [
    "flash",
    "video",
    "swf"
   ],
   "answer_count": 0,
   "favorite_count": 0,
   "question_timeline_url": "/questions/8873828/timeline",
   "question_comments_url": "/questions/8873828/comments",
   "question_answers_url": "/questions/8873828/answers",
   "question_id": 8873828,
   "owner": {
    "user_id": 510346,
    "user_type": "registered",
    "display_name": "Ray",
    "reputation": 594,
    "email_hash": "9431b9ab5c8828c38901923a362a47ae"
   },
   "creation_date": 1326665696,
   "last_activity_date": 1326665696,
   "up_vote_count": 0,
   "down_vote_count": 0,
   "view_count": 1,
   "score": 0,
   "community_owned": false,
   "title": "Can an SWF be played in a player with play, pause, and drag bar at the bottom (i.e. a standard player)? If not,"
  },

	 */
	
	private static final String QUESTION_ROOT_OBJ = "questions";
	private static final String TAGS_OBJ = "tags";
	private static final String ANSWER_COUNT_OBJ = "answer_count";
	private static final String FAVORITE_COUNT_OBJ = "favorite_count";
	private static final String QUESTION_TIMELINE_URL_OBJ = "question_timeline_url";
	private static final String QUESTION_COMMENTS_URL_OBJ = "question_comments_url";
	private static final String QUESTION_ANSWERS_URL_OBJ = "question_answers_url";
	private static final String QUESTION_ID_OBJ = "question_id";
	private static final String OWNER_ROOT_OBJ = "owner";
	private static final String CREATION_DATE_OBJ = "creation_date_obj";
	private static final String LAST_ACTIVITY_DATE_OBJ = "last_activity_date";
	private static final String UP_VOTE_COUNT_OBJ = "up_vote_count";
	private static final String DOWN_VOTE_COUNT_OBJ = "down_vote_count";
	private static final String VIEW_COUNT_OBJ = "view_count";
	private static final String SCORE_OBJ = "score";
	private static final String COMMUNITY_OWNED_OBJ = "community_owned";
	private static final String TITLE_OBJ = "title";
	
	@Override
	public void fromJson(JSONObject jsonObj) throws JSONException {
		JSONArray tagArray = jsonObj.getJSONArray(TAGS_OBJ);
		for (int i = 0; i < tagArray.length(); i++) {
			// Get each tag.
			mTags.add(new Tag(tagArray.getString(i)));
		}
		
		mAnswerCount = jsonObj.getLong(ANSWER_COUNT_OBJ);
		mFavoriteCount = jsonObj.getLong(FAVORITE_COUNT_OBJ);
		mTimelineUrl = jsonObj.getString(QUESTION_TIMELINE_URL_OBJ);
		mCommentsUrl = jsonObj.getString(QUESTION_COMMENTS_URL_OBJ);
		mAnswersUrl = jsonObj.getString(QUESTION_ANSWERS_URL_OBJ);
		mId = jsonObj.getLong(QUESTION_ID_OBJ);
		mOwnerInfo = new UserSummary(jsonObj.getJSONObject(OWNER_ROOT_OBJ));
		mCreationDate = jsonObj.getLong(CREATION_DATE_OBJ);
		mLastActivityDate = jsonObj.getLong(LAST_ACTIVITY_DATE_OBJ);
	}
}
