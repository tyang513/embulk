/*
 * Copyright 2014 The Embulk project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.embulk.spi;

import org.embulk.config.TaskReport;

/**
 * Represents a series of file-like byte sequence outputs in a transaction into a File Output Plugin.
 *
 * @since 0.4.0
 */
public interface TransactionalFileOutput extends Transactional, FileOutput {
    /**
     * Switches the {@link org.embulk.spi.TransactionalFileOutput} to process the next file.
     *
     * @since 0.4.0
     */
    @Override
    void nextFile();

    /**
     * Writes a byte sequence into the {@link org.embulk.spi.TransactionalFileOutput} from {@link org.embulk.spi.Buffer}.
     *
     * @param buffer  the {@link org.embulk.spi.Buffer} to write
     *
     * @since 0.4.0
     */
    @Override
    void add(Buffer buffer);

    /**
     * Finishes the {@link org.embulk.spi.TransactionalFileOutput}.
     *
     * @since 0.4.0
     */
    @Override
    void finish();

    /**
     * Closes the {@link org.embulk.spi.TransactionalFileOutput}.
     *
     * @since 0.4.0
     */
    @Override
    void close();

    /**
     * Aborts the transaction of {@link org.embulk.spi.TransactionalFileOutput}.
     *
     * @since 0.4.0
     */
    @Override
    void abort();

    /**
     * Commits the transaction of {@link org.embulk.spi.TransactionalFileOutput}.
     *
     * @return report
     *
     * @since 0.7.0
     */
    @Override
    TaskReport commit();
}
