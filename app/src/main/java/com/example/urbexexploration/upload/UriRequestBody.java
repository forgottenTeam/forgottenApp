package com.example.urbexexploration.upload;

import android.content.ContentResolver;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;

/**
 * tu nie zabardzo wiemy co wpisac
 */
public class UriRequestBody extends RequestBody{
        private final ContentResolver contentResolver;
        private final Uri uri;

        public UriRequestBody(ContentResolver contentResolver, Uri uri) {
            if (uri == null) throw new NullPointerException("uri == null");
            this.contentResolver = contentResolver;
            this.uri = uri;
        }

        @Nullable
        @Override
        public MediaType contentType() {
           return MediaType.Companion.parse(contentResolver.getType(uri));
        }

        @Override
        public long contentLength() throws IOException {
            return -1;
        }

        @Override
        public void writeTo(@NonNull BufferedSink sink) throws IOException {
            sink.writeAll(Okio.source(contentResolver.openInputStream(uri)));
        }
    }

