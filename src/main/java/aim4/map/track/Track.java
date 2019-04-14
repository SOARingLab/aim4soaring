/*
Copyright (c) 2011 Tsz-Chiu Au, Peter Stone
University of Texas at Austin
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation
and/or other materials provided with the distribution.

3. Neither the name of the University of Texas at Austin nor the names of its
contributors may be used to endorse or promote products derived from this
software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package aim4.map.track;

import java.awt.Shape;

/**
 * The interface of track segments.
 */
public interface Track {

    /**
     * Get the starting waypoint of the track segment.
     *
     * @return the starting waypoint
     */
    WayPoint getStartWayPoint();

    /**
     * Get the ending waypoint of the track segment.
     *
     * @return the ending waypoint
     */
    WayPoint getEndWayPoint();

    /**
     * Get the length of the track.
     *
     * @return the length of the track.
     */
    double getLength();

    /**
     * Get the position on the track that is a given distance from
     * the starting waypoint.  It returns null if the position is off the track
     * (i.e., beyond the ending waypoint.)
     *
     * @param dist the distance from the starting waypoint; null if the
     *             distance is longer than the length of the track.
     */
    TrackPosition getPosition(double dist);

    /**
     * Get the shape of the track segment
     *
     * @return the shape of the track segment
     */
    Shape getShape();

}
