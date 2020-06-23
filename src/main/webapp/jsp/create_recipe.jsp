<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 22.06.2020
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="de">
<head>
    <link rel="stylesheet" href="../css/general_styling.css">
    <link rel="stylesheet" href="../fontawesome/css/all.css">
    <script src="../js/recipes.js"></script>
    <link rel="icon" href="../images/icons_logo/icon.png" type="image/png">
    <title>Übersicht - Trail-Mix</title>
</head>

<body>
<div class="wrapper" id="wrapper">
    <img class="bg-image" src="../images/bg/wood-wallpaper.jpg" alt="bg-image">
    <jsp:include page="include/dynamic/header.jsp"/>

    <div class="regular-top-content-wrapper">
        <div class="regular-top-content-block-text" id="top-text">
            <h1 class="centere">Rezept Hinzufügen</h1>

            <div class="create-recipe">
                <img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxITEhMTExMVFhUXFxgXFxUXFxcYFhcXGBUWFxUXFRcYHSggGBolHRUVITEhJSkrLi4uFx8zODMtNygtLisBCgoKDg0OGhAQGy0lHyUrLSstLS0tLS0rLS0tLS0tLS0tKy0tLS0tLS0tLS0tLS0tLS0tKy0tLS0tLS0tLS0tLf/AABEIAMIBAwMBIgACEQEDEQH/xAAcAAABBQEBAQAAAAAAAAAAAAAFAAMEBgcCAQj/xABCEAABAwIDBQQIBQMCBQUBAAABAAIDBBEFITEGEkFRYSJxgZEHEzJCUqGxwRQjYtHwcoLhkrIVJFPC8TNDc5OiFv/EABkBAAMBAQEAAAAAAAAAAAAAAAABAgMEBf/EACgRAAICAQQABgIDAQAAAAAAAAABAhEDBBIhMRMiMkFRYQWxFGKhUv/aAAwDAQACEQMRAD8ApcjnKM4uRF4UWQpWzosgyNKjviKmvcmHPRbCyG+FRnxog9yk4bs/U1JAhhc6/G1m+ZSJYDLFw2nLjZoJPIC61rA/RA851Mgb+ln7rQMJ2SpKYD1cTb/ERcpkNmE4L6P6yex9XuN5uV/wX0Xwx2Mx33cuC04sTbo0CAlHhMMQtGwN7hmpgYpnqV0IEAQwEg1TvUL31B5fJAEAhINRD8K74T5L38E8+6gAcbrzfKIOoncd0d5CadAwe1LEO94QBFbM8aEpxtbIPeK4krKVvtVUA/vH7qDUbRYaz2qyP+3tfRABP/isiX/FzxaD5KvS7bYSBf8AEOd0bG4n6Jh232FA6zHr6s/dAi0uxZh9qJp72gqDUQ0EhJkpYyee7b6IBJ6QsKHu1B67oH1KTducHdrJOzvjcfpdHIcBSTAsKdrAG9xcFBqNiMLf7LpGdzgR8wpFPi+Fy+xXNaeUjSz/AHAIgzCPWDehlilGvYcDknYqRWJvRpTO9iqt/UwH6FRT6KHH2amInkWlvzzR+rpnsNnNLe8KMZiOJ80WG0rY9FdWSR+UbaESDPuTE/osrQL+qB/pe0/dWttc8aPPmnWY5MPeQHJnNTsHWN1ppvBhP0Q6fZeobrFIO9jh9lr8W0kw4+RcPupDdrHjXe8wf9wRSDkw44LJ8J8ikt0G1XO//wBbEkUO2Y+8KLK1ECE26O6k2BL2JkQOc4NaLuJAAHEnIBEZo1ZfR7h7TLLUPFxAy4H6ze30+aAD2AbM4ZRtaay8tRYFzbEtZfO1h91cINscPaN1rXNA4Blvos4qZS9znHMk3Ka3Fh4rNfBXuabJtxQD3n/6Sortv6DgJT/b/lZuaUar31CpTZDxI0R231F/05T4D90270h0g0hlPl+6z0wpmVoGpVbmS4IvtR6UKdoypnk9XBC5fS8bdmkaD1f/AIWeVtU3QZoY6S6akLYaBV+l6tJ7EULB3F31KHT+lPEjpIxvQMH3VQDV3+FceCbkl2JQb6DFV6QMTe6/4p46NAA8rKHLtFiUp7VVP4PI+lkxShjT2grBTQMcLtslHIpdBLHKPYA9VO7N8sru97j9SvfwnerB+FJ0CdZhBOZVkFZNPfgvW4eTqrSKADgm3wWQIr4oQFy6mVjiw17uGSlMwkDXNMCpNw9x4J5uGAK1fg+i4kpbIEVo0K9iD4jvRucx3xNJafMKxR4c5+gT3/BgNc0ASNntvamO0dU38TDp2retaObXe94+atc1FHNH66kf6xnvM99nRzdQqPJRgL2mrJILGF7mO3t4lvGwsARxGbsjlmgA5ICmiUfw6aKujBduw1Om7o2Q/E2/PPK6E4hQyROLXix/miBkQyLl0hXrmrgj+FAHvrElzYpIAqUj1yXpFNbyizY5kerDsJMd6oZwdHfxF1WZyiuwk9qtreDwWo7QXQcXoTOI1LInuab3BKGS4zyyWLSXZspN9BqyjT1sbdTdV6fEXO4qHJLdTv8Agez5C9XjJ90WQaoqnO1K5Y0uNmgk8gjuHbKyPsZOyOXFRKaXqZpHG5cRRWbEmwF0So8EkdmRYK4Q4XDEOy0X5lNTSXWMtV7RN46T3kCocMYzhdcSsCJ0dBNM7diaXfTxKtuFbCtbZ07rn4Rp4qYQyZXYsk8ePgzqPCJJjusYSedlasC2NfGLyu/tCvjYY4xZjQB0QutrgOK7ceJQOHJlc+EQ/wACxosAFGmiCkiXeCg10r2Zt3T04qp54Q7YQ088nSFFhT5NG2HMqYzBGMF3doqJQ7Yn2XgW05EI6XBw3gbgqoZYz6M8mGWN+YGPjy0sozowjLaJ8mTR48FPp8DYzN53jy4LQyKzDQPf7Iy5qdDgrW+1mfkrBLK1osMghk810WFEOdjRkAhs41RSa18yB3lTsPjowbvla53L3Ut8V2y1jk1aRW4MIkm9lthzOiJR7Oxxi7u075K1yzMDeza3RV6vqybqrIoEVoA0T1JtJYCKoaZYtA6/5jB0N+0Oh80xNCSe9E8N2UDu1M4D9AIv4lO0FHFfg3YEsDvWxHMFoOXeNb96DOi5eXFXpsjYBuxAAcR7pHXmopw+CqcfVH1UoF92w3DzIsEgKZY8v55JL2qxlkb3Mexu80kHeyNxzCSVjoo+9kmrJ1q4BzUM1OXMT+zztyrgP62jzNkzM+2aiMqN17XcnA+RBSQmb5NgVPWwyQyNG+0ndeMnNuLg3WKbVbP1FDJuTN7J9h49lw6Hn0WpUWNeqqhn2ZY2O8bWV2xPDIK2AxTNDmuHiDzaeBWuTGpKzPHkcXR8vQuc47rQSTwGqtWE7IveA6Z243lxVirNipcLkMrPzIb5SZXbfQPH3UmpqxJHvMNnDMjnzsvPyxmvSelgljl6hulpIIBaNo7zr5rmasudUKhnfI7daCT0+6M0+FtbnIf7R9yvNbb7PVVJUgfuuebDNWrAdkoDZ00gefgach380Fq5I7WDQB0y+ar1RiUkLxZ5Lb5Ovm3v6LbDKMXyrMM8HKNRdGxgxxN3WNDQOSE1WLAXzVTwvHpJhuHNw48wp4hAsXm/Qfuu+WpikebDSTb5HZa5zzkFFMABu43PLgvKmuaMm5DkhdRXLinqJS64PQx6WEewlNVgCyF1VRfRQXTuc4NaCSeARekwc23pTb9I18SsLOj6QEloHyuHqxd/kO4laRsps/6qO80jXHXcabhveeKqlZ6sCzLt6gkf+UCOLywvF35XyeMr9HDgurBlUH0cmpwOceGbFLVtGTQAOiDVeIZ21KCYRjYmad49sDTmnH3OZyHzXbLPFKzzoaaTdUP1NT4ngB91xFLujPVR5ZmtGQt1vqhtVXriyaqT4iehj0cVzInVs7dTa/Kyr2JOb7vZdzH3C8ragi2eouoF3PcGtBc46AZlcu92dXCVIfwzaKSM7jibDUcLcwrRh9QZMwOzz/mqF0eyrbtkn1A9gHI/1Hj3BGZprNs0WA5DILpjqZRVI55aSM3bO6tjRrvedlXsTBuTG8g8ibg+OoUueoJ1UN8gvmbLF5JN22dCxxjGkjjCdpJI3bktyOLTqOrTxCLOxfMSRm1sweKpuLVAc0jiM2niD+yiYRiJOXMadeS79Pmb4Z5mpwx7Rscmz9NWn8Ud28oBI5OADXDzaUlR6akrN0boLRwBcB8jokurxYfKOT+Pk+GVJ5so8jk607wTExQBw9xKZjpnONgnaVpLt0alX3ANnMg4hUo2RJ0RsXlMbaN519Xu+Vlp+xWLNla0Xztos+21oHujgDGklpIAAzXezEc9KQ9zwDwZr5lVPNDGvMyceCeV+VF/9JdQBQyRgEySkMja3UneBJPJoANys6wjCXMaHTO/tB+pRTFMcklN3uvy5DuCBVWI24rys2qcn5T18GkjjXn5YXkrGsFmADuQisxXhdB6jETfIlWDCdhaucCR43GnOxPbIPTh4rlUZSfB1SyqP0BxWvcd1tyTwGaI0uzhfnObNPuDU954It+CFMTGIyxw1J9ojnvcQo0uICxzIKl8MuKTVk2J0cTd1jQAPPxPFQp6wuvbvQ2aq81Ko8Hlk7Tvy28z7R7m/uk2WRJaknLU8Ap1HgcjrOkO43W3vHw4IrBDDD7Iu74jm7/ChV2JHPNAifaOFt2AC/H3j3oVVYndCqmuKiwNkldZgJPHkO8pkOXwTqitJFr5Lyhwx0995vYII3jp4cyp1HhLGZykPd8Pujz9pEZMUDRYBvQWHy5IHXuxYbh0dO0WJc4D23anuHBeVeIAIVWYkeaFVFandhaQWqKq4vfjohk9X1UJr3yODGAuceA+/IdSrHheAMZZ05D3cGe4O/4j8u9FCTciHhmEy1FnexGPfPEfpHHv0VnpqeKBtmDPi45uPefsmarFMrA5Dh+wQ99QSpotInz1ZKjS1TrWLjbldRpKgAIXV1qBtkmqrEFq61NVNRcXGt7WGvRGsF2OfJaSpuxvCPR7v6j7g6a9yuK92ZNt9FfosPnqn7sTbi/aecmN73fYZq+4FstDRgOP5kh/9w2t13B7o+fVELNiaGMaGNGgAsPkmJJCcyctLnQX6qt7fliJY4x80iYaw8h5D9kkwIOv0SXR/ByfRzvX4TKmTWTE0tyos8lrq97OejSpmjZNNdrXAERtP5hacwXXybflme5d7lSs8yMbdETYSgbLNd1rDiVqNTiETG7rBew14KrSwx0hMUbNy2oIIcT1Jzd33UGbEeq4smtl1Hj9noYtDD1Td/oNVeIk8UFqa7XNQJKtzzYHLieSFvqFxNuTtnZujFVEny1meeahVTgSbaJqMknwXJeqUTNyDXo8o2y17Q8AhgLrHS+jcvmt6hAsvnrZLERFXRH4g5p+o+i2qLGcrMaXu8mjvd+wK9PSpKJ5mrbcgniWFxTN3ZGg8joR3FY9WYI5sz4/WNc1riA8EHeHDTjwPUFXTHYsQlB7Td3/AKbDu+d/a8T4Khy1bg5zHAtc3ItIsR0IXNrab9NfZ1aHyrmV/QWpKeKL2RvO+I5nw5eC7rKywBvmeCAGrN1xJU9Vw0ehuRKqKu6E1NSvZJrqLLmFaiZSmHNicB/GzkPJEbAC+2Rdc9lt+F7HPotdpdnqeNoayJgA4AD+XVO9EZDad/xGR1/CwHyAWiB69TT4IqNtHk6nPLfSZVNoNjWva50B3H67vuOP/aVlVZK9jnMeC17TZzTqCOa+gis89KmDhrWVjGjeBEcmWrT7Dj1Byv8AqHJZarTRS3xNNNqpXskzLpqvqrJgewVVUtbI4tjjdmN6++W8921hfhc8dECwBjZa+mY4Czn3I4Hda52h6tGS+iKVuQAUafTqfLNdTqHCkjO5dkpKWP8ALYCPeIuXHq7L/Hcq3XVDwbEELZqvE4ogd94Fhne+XHgOSB1m2lI295AbcA0km9rWva+V/Jay0Kb4ZlD8jJKmjKPX2NyfP7rmeuB0sO4/utCrvSDSgXawvN7WLWDLdLsszfS3iqdj21ZqgAyFsYaQ7eDWZnddcHs3trxOil/j3/1/ha/Jf1/0r89YTpmvMOwyWpdutLGC9i+V7WNHnm49ACmTWyOLGlxt2bC9uB+H7pqneGk2Db2BNxbrq3P5qo6BLtkT/IN9I0nDNmaajbvevhkl4vMjbjoxt+z9U1U4pGTYG/cDbz0VEhxO17i1t3QAjO97A2PjddR7UxtzLXeFjrwsbD5pvRRu+Qhr5pVwapgOERSN9ZK6wF+x93Hlaxy5jNU/aDaKOaqjp4t31URLju23S/QWIuDYHXndVTGdu55GBkF4W5guDu04XHIdnTgUF2dnIlBJzK6ceKMOkcuXPPI/MzVBW/zNJCW1H8uktTIq3o5wcVdfGx9txg9a4fFukWbbiLkX6Ar6XjyAC+aPRnWCLEqck2Di6M/3tIHzsvpRpyUJclSfAL2o2fZVxWybIL7j+R5Hm0rC8UY+KV8TwWuYbEdf4V9GsWQ+mPCtyojqAOzK3dd/WzS/e0j/AElcmswprejq0mZp7H0UQVBByJC4L023XXzTEz7Gy4YxO9yJbaqwNtTlfpxUd0yI7PbMVVa60LOzexkdkxv93E9Atl2P9H9LR2e786b43DstP6G8O85rqxaZy5OTLqVHgzbZf0c1tQ9k7x6iNp3gXjtu49lmo8bLV8DpQ2NpA1APyR+tq2RxukkcGtaCXE8AgeAVLZII3sN2uaC08wRcfJd0Mahwjinkc+WE2NVf2u2WbVs3m2bO0dh2gP6X9OvBWJqcaVU4KaqREJuDtHzxUSua4tcCHNNiDqHA2IPVRjNdXT0tYY2OpZOB2ZmG/wD8jLC/iHM/0lZ+12a8aWLZNxPZjl3RUieZyQBySLl5S05P8zJ4ADiUabgMm7d4LenHx5LSGJt8ETyKK5DHowxG3rIzrvbw7jl9QtRglWDUrXU1S2ZnAFpbwc24JHyWs4Li7JWhzTyuOIPIhehj8qpnn5ak7RamOUDaWmElLOwi9432HUNJaR4gFOQy3UPavFWU9JNI9wHYLW34ucCGj79wK0nW12ZQT3KjENnHWrqY9Xf7HL6Bw6S7Qvm7C6687ZIwSI3a8zxA5ZHVfQmzlW2SJrmm4IH871hpk4xpnTqmpO0Zv6VopW1pLXOAfG05OPvD1bsu6Meao8scjjckkZkXvoLNFu4Cy1f0r0mcEgyNntv/AE2c0c8y75KgR0heW6XyF8swDn35ldRxkI07jbPLtEXysAwDIfzRdT0wZcXv4ZZM1FsiLn97ImKS4AdYWGn9Rv45JuqoiSSBf2sv6jYcM8uCAAZhz/x+j/wvHttkSfL4Wd+WoRCoiOZLSB2zYW5ANsT81CkiBub/ABWBv8I08+iAIEjDloBlnfXsqI6mBPM9kdcwjBiGRtkOWgs0E6qJOwbw4jL/AGjTvzQAHkFxkuqB1pG96kSsy5iw878/BRozZ4P6vugZfGvyCS4hN2juXqAM/wC01wcCQQQQRqCDcEL6Z2B2jZXUjJARvtG7K34XgZ+B1HQr51kguE/sztBUYfP62E5HJ8Z9iRvJ3I8jqFmmaSR9Usaqj6WadrsOkJtdjo3Nvz3w028HFO7O+kLD6oMtOyOQ2vFKdxwdbMDeyd3glVD0v7Xwyxfg6dwkO+DK9ubAG5hoPvG9r2yFkZOYtCx8TTMrkl8uavvo72PgqGComJe25AjGTSR8R1Pcs7khJC2D0P5UZbfSR37rPDhiuzbNmlLo0WmDWNDGNDWgWDWgAAdAE8+oaxpc8gNAuSdAhNfiLIGF8jt1o1J+3VZLtltlLV3jZdkPLi7q79l0t0cyVkL0pbcyVjjBAS2naeGRkI4norF6E9pd6M0Up7cd3R395hOYHVp+RHJZ0aS/BdUkb4pGSxktexwc1w1BH24EcQSFi5M2UVVH0/GnA1Z3sn6SYnNDKz8t4y9YATG7qQLlh+XXgrLV7b0DALVDZCdBHd58bZDxIVb0ZuDRUPTRXA/h6fjcynusWN/7vIKlYFs9LOQQLN+M6eHNH5wauodUT2cSbNbbssYCd1tuNr8eJKveDwjdCw8LdJykdHi7IKMSJgGBQQNBaN59vbd7XW3wju+adxGkDgistFxYbHlwKiTwy/B5ELZKuDFu+bM+xmhs5p62+SmYZTPYd5hsfke8KwV+zjpLOcbWzDRz5leUNOWndeMx5EJL7KdVwS6LEZQMwD5oLtrSPqYX+sOTQS1o0BHEDnkrHFCFExlwbFIT8J+mSJJUxQb3IzjYfBA5sn9f/a1aXgVM6H2fZOoVO2D/AC3PY7IuO8PID7LSIAMlGHmCsvPxN0CtvmetpA7jG9r9M87tP+4LPoQMhbK/DTTta87LVcUpvWQyM1u027xmPmAsybBn8suZ1+i3RgxyONhBte5BtkNSe/kpcbbE2aB2z1tuiwt81xHCbgDQkAdwGeXK69uQP7SeXtGwyA6BMR7Uwse3dLRkG683HU+Fvqq1iFIM7A5hzrnkXZWAGWnzVnl1zFu0dP0s5DvUB7QQAdbMF76km9ygRXHxOBNjYjfAF8+y0DlmodW0uJJuSSTex+Ae11/yjdXBcuPO5vbm/wCSiSU4IN9bO0vyA04cfNAAFzdGk/Dw07N+KGVDQN23IH581anYRfMG43tONt237Kr4lHbW+gGfjp80DLbRy9hvckhtFN+W3uSQIj+ryXE9ICFJpjklqbLCR0RAMsFkVoBcWKVTTG911E+yvtE9M7fFulaH6PsSipqeUyHIPuANTccFRJxvN6pYfUPGV0J0S+Q/tJjc1Y/O4jHssGg6nmVAp8JceCP7KUrKhwGTXDUd3EK7w4UxnBHLK4Rn1Ns+48FMOzWWivTmtHBQampY2/RFAmUGrwMt4KI2h3SrZWV2+bAJmDDHPzspaLG8KhtZW/DZ7ID6n1YsbJykxLtAWPemnRLVl1hqhzUhkzTxCr8NQ1SWyMOhIK0syaDDwFDnpmu1C6jBIyN10x10dh0QHQuGh80xPQ7+Ts+nBFnRr2OJLYh7mVmowHtBzciNCilDOW5PyPPgUVMabdSg6hJx90NS9mJlQOaBxbPB0j3DJu92cueZt8/JFqmmYxrnuO61oJJucgBcodsvi+803vm4kDLsgnsjr3pqxSr2H5cBIGXKw6X1KG1OFG+Q1cLf0tCuIlHMH5JOYDqPH+aKiDOKqAtFyPdc6+ntGyF1Qt2QPeAuB8LbrS6vCWPBtkSAO6xuqhjOEujebjI+tcORuBb6hAFYgqALB2hDM7i3tHguJYg7NttHm99LO4+COswcu0B9qMacmkn7LluEOYL8N13T3+FggCDStGYPN2diTfd06cePJV/aPZ5z2+sY0uzYNOYOeQ4K909AM9bF3W9yLEjO4016+KD+kOs9TS9iw3ssuHA7o8T5+TAzqhm/Lb3JJuhH5bcuCSQE92QyXLX2zTchJAsmnXGSxRuydFPvA5KG49pP0xASnjBzCa4Ex1kgsmWybpuo7bgrtpuCmItGzDSS54/nBEKXE5mvcWyO45XuPIrrAKQRU973Lh9r/dQYRm5UP2DzMbke2xtvc+f+U1HTyynQlDmBFaTFpWjdDsu4XHik0BPZRRQi8h7XLimpsWcezGLD5pilw+WY3NzzcUWijig/U7mkOyFDhj3jefkOZUmOjaPZz6puaqc86+ClUY3R3oBtkWRh5qPKXgEglFzFdMVrAGoFY9sxXOILXEnqjrnkG4VY2fjIerHM4hUiJLknwSAp0kIK2rkBvlZPS1nH6J2Kgu1t12GKujEXA65KRHjJCLCgZt7iO61lODm/tP8A6BoPEi/9qFYMQ0a2+mlzl3Z9yC43VOmnklJzccgM7MaLNDefZs7LL2s7r2nlew3vla9x+kXNr6gAh9xlYnPJCEy+Q1Ztr9+/5W7xnwU2Ks6/+QPnl5jNZ6zGpLlrfdBII0O7mdw8mgkgmwtfM8XW47KCdBa9uWXaBF+AvcHK7TxTsk0dlWONv2yz05A+RuotdWRWAcLjzFuPXLLwN1QjtFL3WvfoBY37he45tNsxo0cek1Itn4N5A/0k5c2m2aANKEcZaBu8jYZZtGdh5JiSiY8c/aAz0JzzVHi23fHk6PLLLly15cByKJ0+2sBzdvMsMzbIAai/NpINjwOmSBhKqpSw6ZXGdrZ6ZcOPy8889L8AvSwAkvzJFsrGwBv4cldar0g09i2FjphoCLBhtfMPOreov3KqY3WmqmEpY1pa2wta9zq5zrXJyA6Wy1N2FFWiwI2F3AZaZ5eQKSPMwwkAucb8bWt4XC9SKop4YckpYl1O7OyTWm4XMmdDQ3A7dBuuqaa90pG52Xrod3NaJpmbTGpAVGY8g5p0VNjYrknecBzIVCL9Ryf8uP5yCjQ2zTwbuwsHQfuuIoSc0xjkbCngbd67iBOQU2moOJ1QIcwwyDRxAOo4FOupyDnn1U2nh5Kb6trGkvIA6oaFYOigU9kWQXmE1EMwcYnh+6bOtq09RwUuZ7Wi6QNkd5soM7i82UqxeVPocN4lAWeYHSboueKJTMGpXW7ui5sAFAqZN/PgqJItZU3uG+aHxxEcSiBaOich7kqHYxHCOKhYywiJ27vC/ZFtRfWxOhIuAeZHNFpCeDUKxert2SNOyRci5dla46jdyzDmsOSYmylywSAk2vlkDe5uN4WLsyBmWh19HNtwXD5XDjciziQL6XLSN7Wwu5pOVt4WysnsXxq+TDe53r5XIvqDezbuAN9GPvzVbqK55IaAXPNyGtB3s8rjiMxrzvwTJD0NV2y69gM8uDvc3b5OIzIvwuLC1ly+uaDce6ct3MBwzbbe1ILjZxzLXEACy9wvZbEJQC2F0YcPblJjtofZI3weNw3nnYo9TejYW/5ioc7myJoYO7eN3WvncbpzToCpnGWts7etmbfpNjugHpfWxcWkjIpynkqZLCKGS1snZMa29ySwu4guIuLlzciVoNFsvSwG8cDA4aOI3njO+TnXIGZyClvp0UBnn/8AP1D7GSXcAFt2MadA5w04eze2RJtdPwbPxstZtyOLiXHzdors+mTH4ZA+CusoFMgokXbTpxsKBkAUqSJ+rXqQWYsY7uTpdZcvfc5KPvXJuVgjdsefPmCQuPWkk8l261l6Gi3VCQmyC2HtXKlYXCHytB53TPqynsD/APWz4A/ZWuSHwaXjVKxoj3eX2CgwQE9Ai++2SONw6hctYrA8p4gOCI01OSvaOivmcghG0u2UNM0sjIc/ok2NRcnSDeIYjDTMLnkX5LLNqNsZaglrLtZ0QHFcYlqHFz3HuuozHFZuR3YtNXLH8JxSamlE0Ly148iOIcOIW2bNVza+JsrT2tHt+B3EW5cisPu3iiODYlNTSCSnlLHdNCOTgciO9CkGbDuX2fRFPh4HBR8b2hpKOwmkAeRcRjN5HOw0HU2Cz+m9Lk7WWfTRufbJ7XFrb8yyx+qpFXiH4iV8sxu953nH6AcgNAOiuzkjp5XyadJt/DK6xjka2/tdl3iQD9Lo1TYnSvbvNqIrdXtbboQ4gg96xhsPwOSAc2923Tst4F7G/wAGFlwByIPG+XhZeVrYYBvTSsY3m9waPMlYXR4o+LJkksX9D3sH/wCSAok7TM5z3SOc74nuLnHxdcp2R4D+TbqvaWlbE+SF8UrmjstY9r3OccmgBtzqQqnTbO11bnI6OCN177x9ZKWn9LDugkboIJz3QSCVmTYHsP7IvQbRzw6OePFG5IylimulZrlF6OKFtjIZJT+p260nLUMsTpxJVlosNghbuwxRxjkxobfmTbU9SsepPSTM3Uh3ejtF6T2H/wBRpHUJqSZi3XZosgUd7FXqTbamk0kA6FE4sVjdoQe4qwHZIlHdCpAnadCvd7xQBCfEo5iRM2XhYCkMGerS3EQNNyXDqcoHZD3UlJ9SkkFmCxJh3FJJc6OhjlP7I71zVHMdySSolnrdAuMNP5p7kkko9g+jTNnD/wAq3v8A3ReiHaCSS1JFtW8inNiRlwNlhFY8mRxJJz4pJLOR26U8anmpJLNnfERXTUkkImRMhKdcMkklZi+ziNxuiULjzSSVIiY3WjsqGV4kmTHo7pXG+ql1oy8l6kmujKXqAUwTcbjzSSUsM3pO948yjWCVT7jtu/1FJJVA8xdmmYFM4gXcT3klH4nHmUklsWEISnSEkkmB41PheJJAckL1JJAz/9k=" height="60" width="60">
                <input type="file" value="Bild Hochladen" accept="image/*"> <br>
                <label for="name" >name:</label><br>
                <input type="text" id="name" name="name" value=""><br><br>
                <label for="categorie">Kategorie:</label><br>
                <select id="categorie" name="categorie">
                    <option value="Frühstück">Frühstück</option>
                    <option value="Mittagessen">Mittagessen</option>
                    <option value="Abendessen">Abendessen</option>
                    <option value="Snack">Snack</option>
                </select><br><br>

                <form id="stuff">
                    <label for="amount">amount:</label>
                    <input type="text" id="amount" name="amount" value="amount">
                    <label for="unit">unit:</label>
                    <select id="unit" name="unit">
                        <option value="g">g</option>
                        <option value="kg">kg</option>
                    </select>
                    <label for="ingredient">ingredient:</label>
                    <input type="text" id="ingredient" name="ingredient" value="ingredient">
                    <input type="button" value="add">
                </form>

                <label for="manual">manual:</label><br>
                <textarea id="manual" cols="40" rows="10"></textarea><br><br>
                <input type="submit" value="Save">

                <form method="post" action="index.jsp" enctype="multipart/form-data">
                    <input name="img" type="file" accept="image/*">
                    <input type="submit">
                </form>
            </div>
        </div>

    </div>

    <%@include file="include/static/footer.jsp"%>
</div>

</body>
</html>